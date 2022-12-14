package examples.chap16;

import java.security.SecureRandom;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static examples.chap16.Util.delay;

public class Shop {

    private final String name;
    private final SecureRandom secureRandom;

    public Shop(String name) {
        this(name, new SecureRandom());
    }
    public Shop(String name, SecureRandom secureRandom) {
        this.name = name;
        this.secureRandom = secureRandom;
    }

    /*
    * getPrice 메소드는 상점의 데이터베이스를 이용해서 가격 정보를 얻는 동시에 다른 외부 서비스에도 접근할 것이다.
    * */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>(); // 계산 결과를 포함할 CompletableFuture 를 생성
        new Thread(() -> {
            try {
                double price = calculatePrice(product); // 다른 스레드에서 비동기적으로 계산을 수행한다.
                completableFuture.complete(price); // 계산이 정상적으로 종료되면 Future 에 가격정보를 저장한채로 Future 를 종료한다.
            } catch (Exception e) {
                completableFuture.completeExceptionally(e); // 도중에 문제가 발생하면 발생한 에러를 포함시켜 Future 를 종료한다.
            }
        }).start();

        return completableFuture; // 계산 결과가 완료되길 기다리지 않고 Future 를 반환한다.
    }

    public Future<Double> getPriceAsyncBySupplyAsync(String product) {
        /*
        * CompletableFuture.supplyAsync(Supplier, Executor) 메소드를 통해 다른 Executor 를 지정할 수 있다.
        * SupplyAsync 를 사용한 에러처리도 getPriceAsync 메소드와 동일하다.
        * */
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public double calculatePrice(String product) {
        delay();
        return secureRandom.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
