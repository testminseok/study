package examples.chap17.temperature;

import java.util.concurrent.Flow;

public class Main {
    public static void main(String[] args) {
        /*
        * 뉴욕애 새 Publisher 를 만들고 TempSubscriber 를 구독시킴
        * */
        getTemperatures("New York").subscribe(new TempSubscriber());
    }

    private static Flow.Publisher<TempInfo> getTemperatures(String town) {
        /*
        * 구독한 Subscriber 에게 TempSubscription 을 전송하는 Publisher 를 반환
        * */
        return subscriber -> subscriber.onSubscribe(new TempSubscription(subscriber, town));
    }
}
