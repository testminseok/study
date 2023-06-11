package chapter02.item27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EliminateUncheckedWarnings {
    private int size;
    private Object[] elements;

    public static void main(String[] args) {
        // 경고 발생
        Set<Lark> exaltation = new HashSet();

        // 자바 7부터 지원하는 다이아몬드 연산자(<>) 만으로 컴파일러가 올바른 실제 매개변수를 추론해준다.
        Set<Lark> exaltation2 = new HashSet<>();
    }

    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // unchecked cast 경고 발생
//            return (T[]) Arrays.copyOf(elements, size, a.getClass());

            // 생성한 배열과 매개변수로 받은 배열의 타입이 모두 T[] 로 같으므로 올바른 형변환이다.
            // SuppressWarnings 애너테이션을 사용해 경고를 숨길때는 그 경고를 무시해도 안전한 이유를 항상 주석으로 남겨야 한다.
            @SuppressWarnings("unchecked")
            T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
            return result;
        }

        System.arraycopy(elements, 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    private static class Lark {
    }
}
