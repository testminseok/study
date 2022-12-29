package examples.chap17.rxjava;

public class Main {
    public static void main(String[] args) {
//        Observable<Long> onePerSec = Observable.interval(1, TimeUnit.SECONDS);
//        onePerSec.blockingSubscribe(i -> System.out.println(TempInfo.fetch("New York")));

        /*
        * 에러처리 및 기능 일반화 팩토리 메소드를 제공해 매 초 마다 온도를 방출하는 Observable
        * */
//        TempObservable.getTemperature("New York").blockingSubscribe(new TempObserver());

        /*
        * 섭씨를 화씨로 변경
        * */
        TempObservable.getCelsiusTemperature("New York").blockingSubscribe(new TempObserver());
    }
}
