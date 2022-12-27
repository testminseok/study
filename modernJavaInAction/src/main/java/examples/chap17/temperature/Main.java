package examples.chap17.temperature;

import java.util.concurrent.Flow;

public class Main {
    public static void main(String[] args) {
        /*
        * 뉴욕애 새 Publisher 를 만들고 TempSubscriber 를 구독시킴
        * */
//        getTemperatures("New York").subscribe(new TempSubscriber());

        /*
        * 뉴욕에서 섭씨 온도를 전솔항 Publisher 를 만든다.
        * */
        getCelsiusTemperatures("New York").subscribe(new TempSubscriber());
    }

    private static Flow.Publisher<TempInfo> getCelsiusTemperatures(String town) {
        return subscriber -> {
            /*
            * Processor 를 만들고 Subscriber 와 반환된 Publisher 사이로 연결
            * */
            TempProcessor tempProcessor = new TempProcessor();
            tempProcessor.subscribe(subscriber);
            tempProcessor.onSubscribe(new TempSubscription(tempProcessor, town));
        };
    }

    private static Flow.Publisher<TempInfo> getTemperatures(String town) {
        /*
        * 구독한 Subscriber 에게 TempSubscription 을 전송하는 Publisher 를 반환
        * */
        return subscriber -> subscriber.onSubscribe(new TempSubscription(subscriber, town));
    }
}
