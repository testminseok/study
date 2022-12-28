package examples.chap17.rxjava;

import examples.chap17.temperature.TempInfo;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class TempObserver implements Observer<TempInfo> {
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull TempInfo tempInfo) {
        System.out.println(tempInfo);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        System.out.println("Got problem : " + e.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("is Done!");
    }
}
