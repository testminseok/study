package examples.chap16;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

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
}