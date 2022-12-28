package examples.chap17.rxjava;

import examples.chap17.temperature.TempInfo;
import io.reactivex.rxjava3.core.Observable;

public class Main {
    public static void main(String[] args) {
//        Observable<Long> onePerSec = Observable.interval(1, TimeUnit.SECONDS);
//        onePerSec.blockingSubscribe(i -> System.out.println(TempInfo.fetch("New York")));

        /*
        * 에러처리 및 기능 일반화 팩토리 메소드를 제공해 매 초 마다 온도를 방출하는 Observable
        * */
        Observable<TempInfo> observable = TempObservable.getTemperature("New York");
        observable.blockingSubscribe(new TempObserver());
    }
}
