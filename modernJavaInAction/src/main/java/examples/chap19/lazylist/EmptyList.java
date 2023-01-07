package examples.chap19.lazylist;

public class EmptyList<T> implements MyList<T> {
    @Override
    public T head() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MyList<T> tail() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return MyList.super.isEmpty();
    }
}
