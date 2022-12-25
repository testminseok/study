package examples.chap17.temperature;

import java.util.concurrent.Flow;

public class TempSubscription implements Flow.Subscription {

    private final Flow.Subscriber<? super TempInfo> subscriber;
    private final String town;

    public TempSubscription(Flow.Subscriber<? super TempInfo> subscriber, String town) {
        this.subscriber = subscriber;
        this.town = town;
    }

    @Override
    public void request(long n) {
        /*
        * Subscriber 가 만든 요청을 한 개씩 반복
        * */
        for (long i = 0L; i < n; i++) {
            try {
                subscriber.onNext(TempInfo.fetch(town)); // 현재 온도를 Subscriber 로 전달
            } catch (Exception e) {
                subscriber.onError(e); // 온도를 가져오는데 실패하면 Subscriber 에게 에러를 전달.
                break;
            }
        }
    }

    @Override
    public void cancel() {
        subscriber.onComplete(); // 구독이 취소되면 완료(onComplete) 신호로 Subscriber 로 전달.
    }
}
