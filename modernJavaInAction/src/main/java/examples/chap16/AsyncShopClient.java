package examples.chap16;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncShopClient {
    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("myNotebook"); // 1초 딜레이
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");
        try {
            /*
            * 가격 정보가 있으면 Future 에서 가격 정보를 읽고, 가격 정보가 없으면 가격 정보를 받을 때까지 블록한다.
            * */
            System.out.printf("Price is %.2f%n", futurePrice.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
}
