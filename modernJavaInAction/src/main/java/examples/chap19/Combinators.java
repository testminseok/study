package examples.chap19;

import java.util.function.Function;

/**
 * 함수형 프로그래밍에서는 두 함수를 인수로 받아 다른 함수를 반환하는 등 함수를 조합하는 고차원 함수를 많이 사용하게 된다.
 * 이처럼 함수를 조합하는 기능을 콤비네이터라고 부른다.
 * */
public class Combinators {

    public static void main(String[] args) {
        System.out.println(repeat(3, (Integer x) -> 2 * x).apply(10));
    }

    /**
     * 함수를 조합(function composition)한다.
     * compose 함수는 f 와 g 를 인수로 받아서 f 의 기능을 적용한 다음에 g 의 기능을 적용하는 함수를 반환한다.
     * 이 개념을 활용하면 반복 과정에서 전달되는 가변 상태 함수형 모델 등 반복 기능을 좀 더 다양하게 활용할 수 있다.
     * */
    public static <A, B, C> Function<A, C> compose(Function<B, C> g, Function<A, B> f) {
        return x -> g.apply(f.apply(x));
    }

    public static <A> Function<A, A> repeat(int n, Function<A, A> f) {
        return n == 0 ? // n 이 0이면 '아무것도 하지 않음'을 알리는 함수를 반환 
                x -> x : compose(f, repeat(n - 1, f)); // n 이 0이 아니면 f 를 n-1만큼 반복 실행한 다음에 f 를 한번더 실행
    }
}
