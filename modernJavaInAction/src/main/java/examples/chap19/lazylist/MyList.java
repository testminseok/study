package examples.chap19.lazylist;

public interface MyList<T> {

    T head();

    MyList<T> tail();

    default boolean isEmpty() {
        return true;
    }
}
