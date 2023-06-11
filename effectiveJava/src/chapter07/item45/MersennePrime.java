package chapter02.item45;

import java.math.BigInteger;
import java.util.stream.Stream;

public class MersennePrime {
    public static void main(String[] args) {
        // 처음 20개의 메르센 소수를 출력
        primes().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
    }

    private static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }
}
