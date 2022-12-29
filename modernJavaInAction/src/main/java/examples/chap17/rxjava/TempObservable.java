package examples.chap17.rxjava;

import examples.chap17.temperature.TempInfo;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class TempObservable {
    public static Observable<TempInfo> getTemperature(String town) {
        return Observable.create(emitter -> // Observer 를 소비하는 함수로부터 Observable 생성
                Observable.interval(1, TimeUnit.SECONDS) // 매 초마다 무한으로 증가하는 일련의 long 값을 방출하는 Observable
                        .subscribe(i -> {
                            if (!emitter.isDisposed()) { // 소비된 Observer 가 아직 폐기되지 않았으면 어떤 작업을 수행
                                if (i >= 5) { // 온도를 5번 보고했으면 Observer 를 완료하고 스트림을 종료
                                    emitter.onComplete();
                                } else {
                                    try {
                                        emitter.onNext(TempInfo.fetch(town)); // 아니면 온도를 Observer 로 보고
                                    } catch (Exception e) {
                                        emitter.onError(e); // 에러가 발생하면 Observer 에 전파
                                    }
                                }
                            }
                        }));
    }

    /**
     * Observable map 함수를 이용하여 화씨를 섭씨로 변경
     * */
    public static Observable<TempInfo> getCelsiusTemperature(String town) {
        return getTemperature(town)
                .map(tempInfo -> new TempInfo(tempInfo.town(), (tempInfo.temp() - 32) * 5 / 9));
    }

    /**
    * 퀴즈 - 사용자가 동상에 걸릴 위험이 있을때 알려주는 경고 시스템 (온도가 섭씨 0도 이하일 경우만 온도를 방출)
    * */
    public static Observable<TempInfo> getSubZeroTemperature(String town) {
        return getCelsiusTemperature(town)
                .filter(tempInfo -> tempInfo.temp() <= 0);
    }
}
