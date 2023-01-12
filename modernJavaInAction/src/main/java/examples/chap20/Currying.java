package examples.chap20;

import java.util.function.Function;
import java.util.stream.Stream;

public class Currying {

    public static void main(String[] args) {
        int r = multiply(2, 10);
        System.out.println(r);

        Stream.of(1, 3, 5, 7)
                .map(multiplyCurry(2))
                .forEach(System.out::println);
    }

    /**
     * 스칼라 코드
     * def multiply(x: Int, y: Int) = x * y
     * val r = multiply(2, 10);
     * */
    public static int multiply(int x, int y) {
        return x * y;
    }

    /**
     * multiplyCurry 가 반환하는 함수는 x 와 인수 y를 곱한 값(정수값) 을 챕처한다.
     * 스칼라 코드
     * def multiplyCurry(x :Int)(y :Int) = x * y // 커리된 함수 정의
     * val r = multiplyCurry(2)(10) // 커리된 함수 호출
     * */
    public static Function<Integer, Integer> multiplyCurry(int x) {
        return y -> x * y;
    }
}
