package chapter02.item32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenericVarargs {

    public static void main(String[] args) {
        // 제네릭 varargs 배열 매개변수에 값을 저장하는 것은 안전하지 않다.
        List<String>[] stringLists = new List[10];
//        dangerous(stringLists);

        // 자신의 제네릭 매개변수 배열의 참조를 노출한다. - 안전하지 않다.
        String[] attributes = pickTwo("좋은", "빠른", "저렴한");
    }

    // 제네릭과 varargs를 혼용하면 타입 안전성이 깨진다. - unsafe
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // 힙 오염 발생
        String s = stringLists[0].get(0); // ClassCastException
    }

    // 자신의 제네릭 매개변수 배열의 참조를 노출한다. - 안전하지 않다.
    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                // T[] 타입의 배열을 반환하고자 할 때는 ClassCastException 이 발생한다.
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
            default:
                throw new AssertionError(); // 도달할 수 없다.
        }
    }
    
    /*
    * 제네릭 varargs 매개변수를 안전하게 사용하는 메서드
    * @SafeVarargs 규칙
    * - varargs 매개변수 배열에 아무것도 저장하지 않는다.
    * - 그 배열을 신뢰할 수 없는 코드에 노출하지 않는다.
    * */
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }
}
