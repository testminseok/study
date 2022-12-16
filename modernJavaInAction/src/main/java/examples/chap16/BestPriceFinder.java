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
     * */
    public static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop ->
                        String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .toList();
    }

    /**
     * 1초
     * */
    public static List<String> findPricesByParallel(String product) {
        return shops.parallelStream()
                .map(shop ->
                        String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .toList();
    }

    /**
     * 2초
     * */
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
     * */
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
}
