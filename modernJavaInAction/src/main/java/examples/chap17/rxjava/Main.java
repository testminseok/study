package examples.chap17.rxjava;

import examples.chap17.temperature.TempInfo;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Observable<Long> onePerSec = Observable.interval(1, TimeUnit.SECONDS);
        onePerSec.blockingSubscribe(i -> System.out.println(TempInfo.fetch("New York")));
    }
}
