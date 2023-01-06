package examples.chap19;

import java.util.stream.IntStream;

public class LazyLists {

    public static void main(String[] args) {
        IntStream numbers = numbers();
        int head = head(numbers);
        IntStream filtered = tail(numbers).filter(n -> n % head != 0);
    }

    /**
     * 1단계 스트림 숫자 얻기
     * */
    public static IntStream numbers() {
        return IntStream.iterate(2, n -> n + 1);
    }

    /**
     * 2단계 머리 획득
     */
    public static int head(IntStream numbers) {
        return numbers.findFirst().getAsInt();
    }

    /**
     * 3단계 꼬리 필터링
     * */
    public static IntStream tail(IntStream numbers) {
        return numbers.skip(1);
    }

    /**
     * 4단계 재귀적으로 소수 스트림 생성
     * - IllegalStateException: stream has already been operated upon or closed
     * */
    public static IntStream primes(IntStream numbers) {
        int head = head(numbers);
        /*
        * 정적 메소드 IntStream.concat 은 두개의 스트림 인스턴스를 인수로 받는데, 두 번째 인수가 primes 를 직접 재귀적으로
        * 호출하면서 무한 재귀에 빠지게된다. 자바 8에서 '재귀적 정의 허용하지 않음'과 같은 스트림 규칙은 우리에게 아무런 해를 끼치지 않으며
        * 오히려 데이터베이스 같은 질의를 표현하고 병렬화할 수 있는 능력을 얻을 수 있다. 그래서 자바 8의 설계자는 이 같은 제한을 두었다.
        * 결론적으로 concat 의 두 번째 인수에서 primes 를 게으르게 평가하는 방식으로 문제를 해결할 수 있다.
        * (좀 더 기술적인 프로그래밍 언어의 용어로는 게으른 평가(lazy evaluation)를 비엄격한 평가(non-strict evaluation)
        * 또는 이름에 의한 호출(call by name) 이라고 한다) 즉 소수를 처리할 필요가 있을 때만 스트림을 실제로 평가한다.
        * */
        return IntStream.concat(IntStream.of(head), primes(tail(numbers).filter(n -> n % head != 0)));
    }
}
