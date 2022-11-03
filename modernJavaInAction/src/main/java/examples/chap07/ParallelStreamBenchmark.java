package examples.chap07;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
public class ParallelStreamBenchmark {
    private static final long N = 10_000_000L;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ParallelStreamBenchmark.class.getSimpleName())
                .warmupIterations(3)           // 사전 테스트 횟수
                .measurementIterations(10)      // 실제 측정 횟수
                .forks(1)                       //
                .build();
        new Runner(opt).run();
    }

    // avgt   10  120.239 ± 8.715  ms/op
//    @Benchmark
    public long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1)
                .limit(N)
                .reduce(0L, Long::sum);
    }

    // avgt   10    3.839 ± 0.097  ms/op
//    @Benchmark
    public long iterativeSum() {
        long result = 0;
        for (long i = 1L; i <= N; i++) {
            result += i;
        }
        return result;
    }

    // avgt   10  377.647 ± 67.519  ms/op
//    @Benchmark
    public long parallelSum() {
        return Stream.iterate(1L, i -> i + 1)
                .limit(N)
                .parallel() // 스트림을 병렬 스트림으로 변환 (스트림이 여러 청크로 분할되어 있다.)
                .reduce(0L, Long::sum);
    }

    // avgt   10    3.797 ±  0.014  ms/op
//    @Benchmark
    public long rangedSum() {
        return LongStream.rangeClosed(1, N)
                .reduce(0L, Long::sum);
    }
    // avgt   10  1.799 ± 1.562  ms/op
    @Benchmark
    public long parallelRangedSum() {
        return LongStream.rangeClosed(1, N)
                .parallel()
                .reduce(0L, Long::sum);
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }
}
