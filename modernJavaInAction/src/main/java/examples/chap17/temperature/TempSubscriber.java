package examples.chap17.temperature;

import java.util.concurrent.Flow;

/**
 * TempSubscriber 레포트를 관찰하면서 각 도시에 설치된 센서에서 보고한 온도 스트림을 출력한다.
 * */
public class TempSubscriber implements Flow.Subscriber<TempInfo> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        /*
        * 구독을 저장하고 첫 번째 요청을 전달.
        * */
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(TempInfo tempInfo) {
        /*
        * 수신한 온도를 출력하고 다음 정보를 요청
        * */
        System.out.println(tempInfo);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        /*
        * 에러가 발생하면 에러 메세지 출력
        * */
        System.err.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("is Done!");
    }
}
