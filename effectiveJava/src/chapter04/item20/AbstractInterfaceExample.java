package chapter02.item20;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class AbstractInterfaceExample {
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);

        // List 의 골격구현클래스인 AbstractList 를 이용해 List 의 모든 메서드를 재정의 하지 않고도 List 를 구현할 수 있다.
        return new AbstractList<>() {
            @Override
            public Integer get(int index) {
                return a[index];
            }

            @Override
            public Integer set(int index, Integer element) {
                int oldVal = a[index];
                a[index] = element; // 오토언박싱
                return oldVal; // 오토박싱
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}
