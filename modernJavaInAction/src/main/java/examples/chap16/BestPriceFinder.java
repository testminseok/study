package examples.chap16;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BestPriceFinder {
    private static final List<Shop> shops = List.of(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

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
}
