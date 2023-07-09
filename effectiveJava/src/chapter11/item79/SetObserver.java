package chapter11.item79;

@FunctionalInterface
public interface SetObserver<E> {
    // ObservableSet 의 상태가 바뀔 때마다 호출된다.
    void added(ObservableSet<E> set, E element);
}
