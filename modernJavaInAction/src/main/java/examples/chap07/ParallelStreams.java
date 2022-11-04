package examples.chap07;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] args) {
        /*
        * 병렬 스트림에서 사용하는 스레드 풀
        * 병렬 스트림은 내부적으로 ForkJoinPool 을 사용하며, Runtime.getRuntime().availableProcessors() 가 반환하는
        * 값의 상응 하는 스레드를 갖는다.
        * 일반적으로 기기의 프로세서 수와 같으므로 특별한 이유가 없다면 기본값을 그대로 사용하는것이 좋다.
        * */
        System.out.println(sequentialSum(100));
        System.out.println(iterativeSum(100));
        System.out.println(parallelSum(100));
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (int i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel() // 스트림을 병렬 스트림으로 변환 (스트림이 여러 청크로 분할되어 있다.)
                .reduce(0L, Long::sum);
    }

    /*
    * 병렬 스트림에서 발생하는 많은 문제는 아래의 메소드 처럼
    * 공유된 상태를 변경하는 알고리즘을 사용하기 때문이다.
    * */
    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
                .forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
                .parallel()
                .forEach(accumulator::add);
        return accumulator.total;
    }
}
