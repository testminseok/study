package chapter02.item30;

import java.beans.Transient;
import java.util.*;
import java.util.function.UnaryOperator;

public class GenericMethod {

    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    public static void main(String[] args) {
        Set<String> guys = new HashSet<>(Arrays.asList("톰", "딕", "해리"));
        Set<String> stooges = new HashSet<>(Arrays.asList("래리", "모에", "컬리"));
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);


        // 제네릭 싱글턴을 사용하는 예
        String[] strings = {"삼베", "대마", "나일론"};
        UnaryOperator<String> sameString = identityFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = identityFunction();
        for (Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }
    }

    // 재귀적 타입 한정을 이용해 상호 비교할 수 있음을 표현했다.
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("컬렉션이 비어 있습니다.");
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return result;
    }

    // 제네릭 싱글턴 팩터리 패턴
    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static Set<String> union(Set<String> s1, Set<String> s2) {
        s1.addAll(s2);
        return s1;
    }
}
