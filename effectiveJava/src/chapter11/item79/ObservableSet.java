package chapter11.item79;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 교착상태와 데이터 훼손을 피하려면 동기화 영역 안에서 외계인 메서드를 절대 호출하지 말자.
 * 일반화해 이야기하면, 동기화 영역 안에서의 작업은 최소한으로 줄이자.
 * 가변클래스를 설계할 때는 스스로 동기화해야 할지 고민하자.
 * 멀티코어 세상인 지금은 과도한 동기화를 피하는 게 어느 때보다 중요하다.
 * 합당한 이유가 있을 때만 내부에서 동기화 하고, 동기화했는지 여부를 문서에 명확히 밝히자
 * */
public class ObservableSet<E> extends ForwardingSet<E> {

    private final List<SetObserver<E>> observers = new ArrayList<>();
    private final List<SetObserver<E>> observers2 = new CopyOnWriteArrayList<>();

    public ObservableSet(Set<E> s) {
        super(s);
    }

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

//        set.addObserver((s, e) -> System.out.println(e));

        /*
        * ConcurrentModificationException 이 발생한다
        * added 메서드 호출이 일어난 시점이 notifyElementAdded 가 관찰자들의 리스트를 순회중이기 때문이다.
        * */
        set.addObserver(new SetObserver<>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
//                if (element == 23) {
//                    set.removeObserver(this);
//                }
            }
        });

        /*
        * 예외는 나지 않지만 교착상태에 빠지게 된다.
        * 백그라운드 스레드가 s.removeObserver(this) 를 호출하면 Observer 를 locking 하려 하지만 lock 을 얻을 수 없다.
        * 메인 스레드가 이미 lock 을 얻었기 때문이다. 그와 동시에 메인 스레드는 백그라운드 스레드가 Observer 를 제거할 때까지 기다린다.
        * 메인스레드 => add => notifyElementAdded (lock) => Observer.added()
        * => removeObserver (lock 이 메인스레드의 notifyElementAdded 에 의해서 반환되지 않았음으로 lock 을 얻지 못하고 대기함)
        * => 메인스레드 는 백그라운드 스레드의 removeObserver 가 끝날때까지 기다림 => 교착상태
        * */
        set.addObserver(new SetObserver<>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if (element == 23) {
                    ExecutorService executorService = Executors.newSingleThreadExecutor();
                    try {
                        executorService.submit(() -> set.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException e) {
                        throw new AssertionError(e);
                    } finally {
                        executorService.shutdown();
                    }
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public void addObserver2(SetObserver<E> observer) {
        observers2.add(observer);
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    public boolean removeObserver2(SetObserver<E> observer) {
        return observers2.remove(observer);
    }

    private void notifyElementAdded(E element) {
        synchronized (observers) {
            for (SetObserver<E> observer : observers) {
                observer.added(this, element);
            }
        }
    }

    /*
    * 외계인 메서드를 동기화 블록 바깥으로 옮겼다
    * 그러므로 lock 이 해제되어 added 메서드에 removeObserver 가 호출될때 lock 을 획득한다.
    * */
    private void notifyElementAdded2(E element) {
        List<SetObserver<E>> snapshot = null;
        synchronized (observers) {
            snapshot = new ArrayList<>(observers);
        }

        for (SetObserver<E> observer : snapshot) {
            observer.added(this, element);
        }
    }

    /*
    * CopyOnWriteArrayList 를 사용해 구현한 스레드 안전하고 관찰 가능한 집합
    * CopyOnWriteArrayList 는 내부를 변경하는 작업은 항상 깨끗한 복사본을 만들어 수행하도록 구현했다.
    * 내부의 배열은 절대 수정되지 않으니 순회할 때 lock 이 필요 벗어 매우 빠르다
    * */
    private void notifyElementAdded3(E element) {
        for (SetObserver<E> observer : observers2) {
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added) {
            notifyElementAdded2(element);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            result |= add(element); // notifyElementAdded 를 호출한다.
        }
        return result;
    }
}
