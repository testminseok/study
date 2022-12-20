package examples.chap16;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class BestPriceFinder {
    private static final List<Shop> shops = List.of(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    /*
     * 상점 수만큼의 스레드를 갖는 풀을 생성한다.
     * 쓰레드 풀의 최적값을 찾는 방법
     * N(threads) = Ncpu * Ucpu * (1 + W/C)
     * Ncpu : Runtime.getRuntime().availableProcessors() 가 반환하는 코어 수
     * Ucpu : 0 과 1 사이의 값을 갖는 CPU 활용 비율
     * W/C : 대기시간과 계산시간의 비율
     * */
    private static final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true); // 프로그램 종료를 방해하지 않는 데몬스레드를 사용.
            return thread;
        }
    });

    /**
     * 4초
     */
    public static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop ->
                        String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .toList();
    }

    /**
     * 병렬 스트림에서는 스트림이 사용하는 스레드 풀의 크기가 고정되어 있어서 상점 수가 늘어났을 때처럼 검색 대상히 확장되었을 때
     * 우연하게 대응할 수 없다.
     * 1초
     */
    public static List<String> findPricesByParallel(String product) {
        return shops.parallelStream()
                .map(shop ->
                        String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .toList();
    }

    /**
     * 2초
     */
    public static List<String> findPricesByCompletableFuture(String product) {
        /*
         * 하나의 파이프라인으로 연결하게 되면 모든 가격 정보 요청이 동기적, 순차적으로 이루어지게된다.
         * */
        List<CompletableFuture<String>> completableFutures = shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(() ->
                                String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
                .toList();

        return completableFutures.stream()
                .map(CompletableFuture::join)
                .toList();
    }

    /**
     * 1초 쓰레드 풀의 생성 갯수 만큼 1초의 시간을 유지한다.
     * ex) 상점의 갯수가 400개 일때 까지는 1초의 시간을 유지
     */
    public static List<String> findPricesByCompletableFutureAndExecutor(String product) {
        List<CompletableFuture<String>> completableFutures = shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(
                                () -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)),
                                executor
                        )
                )
                .toList();

        return completableFutures.stream()
                .map(CompletableFuture::join)
                .toList();
    }

    /**
     * 8초 - 상점에서 할인전 가격얻기 4초 , 할인율 적용 4초
     */
    public static List<String> findPricesByDiscount(String product) {
        return shops.stream()
                .map(shop -> shop.getPriceByDiscountCode(product)) // 각 상점에서 할인 전 가격얻기.
                .map(Quote::parse) // 상점에서 반환한 문자열을 Quote 객체로 변환하기
                .map(Discount::applyDiscount) // Discount 서비스를 이용해서 각 Quote 에 할인을 적용한다.
                .toList();
    }

    /**
     * 2초 - 두가지 작업을 비동기로 호출해 상점에서 할인전 가격얻기 1초, 할인율 적용 1초
     * */
    public static List<String> findPricesByDiscountAsync(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(() -> shop.getPriceByDiscountCode(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .toList();

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .toList();
    }

    /**
     * 독립 CompletableFuture 와 비독립 CompletableFuture 합치기
     * */
    public static List<String> findUSDPricesInJDK8(String product) {
        List<CompletableFuture<String>> completableFutures = shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(() -> shop.getPrice(product)) // 제품가격 정보를 요청하는 첫번째 태스크 생성
                                .thenCombine(
                                        CompletableFuture.supplyAsync(
                                                /*
                                                * USD, EUR 의 환율 정보를 요청하는 독립적인 두 번째 태스크를 생성한다.
                                                * */
                                                () -> ExchangeService.getRate(Money.EUR, Money.USD)
                                        ),
                                        /*
                                        * 두 결과를 곱해서 가격과 환율 정보를 합친다.
                                        * */
                                        (price, rate) -> price * rate
                                ).thenApply(price -> shop.getName() + " price is " + price)
                ).toList();

        return completableFutures.stream()
                .map(CompletableFuture::join)
                .toList();
    }

    /**
     * 자바 8과 자바 7의 비교
     * - 자바 8 에서는 CompletableFuture 를 람다 표현식을 사용하여 다양한 동기 태스크, 비동기 태스크를 활용해서 복잡한 연산 수행방법을
     *   선언형 API 로 만들 수 있다. ( 가독성이 좋아진다 )
     * */
    public static List<String> findUSDPricesInJDK7(String product) {
        /*
        * 태스크를 스레드 풀에 제출할 수 있도록 서비스 생성
        * */
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Double>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            final Future<Double> futureRate = executorService.submit(new Callable<Double>() {
                @Override
                public Double call() throws Exception { // EUR, USD 환율 정보를 가져올 Future 생성
                    return ExchangeService.getRate(Money.EUR, Money.USD);
                }
            });

            final Future<Double> futureUSDPrice = executorService.submit(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    double eurPrice = shop.getPrice(product); // 두 번째 Future 로 상점에서 요청 제품의 가격을 검색
                    return eurPrice * futureRate.get();  // 가격을 검색한 Future 를 이용해서 가격과 환율을 곱한다.
                }
            });

            priceFutures.add(futureUSDPrice);
        }

        List<String> result = new ArrayList<>();
        for (Future<Double> priceFuture : priceFutures) {
            try {
                result.add(" price is " + priceFuture.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    public static List<String> findUSDPrices(String product) {
        List<CompletableFuture<String>> completableFutures = shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(() -> shop.getPrice(product)) // 제품가격 정보를 요청하는 첫번째 태스크 생성
                                .thenCombine(
                                        CompletableFuture.supplyAsync(
                                                /*
                                                 * USD, EUR 의 환율 정보를 요청하는 독립적인 두 번째 태스크를 생성한다.
                                                 * */
                                                () -> ExchangeService.getRate(Money.EUR, Money.USD)
                                        /*
                                        * ex) 환전 서비스가 일 초 안에 결과를 제공하지 않으면 기본 환율값을 적용
                                        * */
                                        ).completeOnTimeout(Money.DEFAULT.getRate(), 1, TimeUnit.SECONDS),
                                        /*
                                         * 두 결과를 곱해서 가격과 환율 정보를 합친다.
                                         * */
                                        (price, rate) -> price * rate
                                )
                                /*
                                 * 3초 뒤에 작업이 완료되지 않으면 Future 가 TimeOutException 을 발생시키도록 설정.
                                 * 자바 9에서는 비동기 타임아웃 관리 기능이 추가됨
                                 * */
                                .orTimeout(3, TimeUnit.SECONDS)
                                .thenApply(price -> shop.getName() + " price is " + price)
                ).toList();

        return completableFutures.stream()
                .map(CompletableFuture::join)
                .toList();
    }

    /*
    * 단순하게 CompletableFuture 의 행동을 등록한다.
    * */
    public static Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPriceByDiscountCode(product),
                        executor
                ))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote),
                                executor
                        )
                ));
    }

    public static void printStreamPrices(String product) {
        CompletableFuture[] completableFutures = findPricesStream(product)
                .map(f -> f.thenAccept(System.out::println))
                .toArray(size -> new CompletableFuture[size]);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);
        voidCompletableFuture.join(); // 모든 CompletableFuture 의 실행완료를 기다린다.

//        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(completableFutures);
//        objectCompletableFuture.join(); // 하나의 CompletableFuture 의 실행완료를 기다린다.
    }
}