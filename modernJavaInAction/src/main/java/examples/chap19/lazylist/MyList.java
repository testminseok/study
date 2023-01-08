package examples.chap19.lazylist;

import java.util.function.Predicate;

public interface MyList<T> {

    T head();

    MyList<T> tail();

    default boolean isEmpty() {
        return true;
    }

    default MyList<T> filter(Predicate<T> predicate) {

        if (isEmpty()) {
            return this;
        }

        if (predicate.test(head())) {
            return new LazyList<>(head(), () -> tail().filter(predicate));
        }

        return tail().filter(predicate);
    }
}
