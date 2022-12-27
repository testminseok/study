package examples.chap17.temperature;

import java.util.concurrent.Flow;

/**
 * Processor 는 Subscriber 이며 동시에 Publisher 이다.
 * Processor 의 목적은 Publisher 를 구독한 다음 수신한 데이터를 가공해 다시 제공하는 것이다.
 * */
public class TempProcessor implements Flow.Processor<TempInfo, TempInfo> {

    private Flow.Subscriber<? super TempInfo> subscriber;

    @Override
    public void subscribe(Flow.Subscriber<? super TempInfo> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscriber.onSubscribe(subscription); // 업스트림 구독자에게 전달
    }

    @Override
    public void onNext(TempInfo tempInfo) {
        /*
        * 섭씨 온도로 변환한 후 TempInfo 를 다시 전송
        *  */
        subscriber.onNext(new TempInfo(tempInfo.town(), (tempInfo.temp() - 32) * 5 / 9));
    }

    @Override
    public void onError(Throwable throwable) {
        subscriber.onError(throwable); // 업스트림 구독자에게 전달
    }

    @Override
    public void onComplete() {
        subscriber.onComplete(); // 업스트림 구독자에게 전달
    }
}
