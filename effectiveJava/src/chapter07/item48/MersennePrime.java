package chapter02.item48;

import java.math.BigInteger;
import java.util.stream.Stream;

public class MersennePrime {
    public static void main(String[] args) {
        /*
        * 데이터 소스가 Stream.iterate 거나 중간 연산으로 limit 을 사용하면 파이프라인 병렬화로 성능 개선을 기대할 수 없다.
        * 스트림의 소스가 ArrayList, HashMap, HashSet, ConcurrentHashMap,
        * 배열, int 범위, long 범위, 배열 int 범위, 배열 long 범위 중 하나라면 병렬화의 효과가 가장 크다.
        * 스트림을 잘못 병렬화하면 (응답 불가를 포함해) 성능이 나빠질 뿐만 아니라 결과 자체가 잘못되거나 예상못한 동작이 발생할 수 있다.
        * ex) 해당 main 코드를 실행하면 아무것도 출력하지 못하면서 CPU 는 90%나 잡아먹는 상태가 무한히 계속된다.
        * */
        primes().parallel().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
    }

    private static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }
}
