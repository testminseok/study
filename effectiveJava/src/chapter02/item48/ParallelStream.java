package chapter02.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ParallelStream {

    // 소수 계산 스트림 파이프라인 - 병렬화에 적합하다.
    public static long pi(long n) {
        return LongStream.rangeClosed(2,n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    public static long pi2parallel(long n) {
        return LongStream.rangeClosed(2,n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}
