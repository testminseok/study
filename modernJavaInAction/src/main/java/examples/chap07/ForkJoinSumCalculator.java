package examples.chap07;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/*
* forkJoin 제대로 사용하는법
* - join 메소드는 분할하고자 하는 서브태스크가 모두 시작된 다음에 호출해야 한다. 그렇지 않으면 각각의 서브태스크가 다른 태스크가 끝나길
*   기다리는 일이 발생한다.
* - RecursiveTask 내에서는 ForkJoinPool 의 invoke 메소드를 사용하지 말아야 한다. 대신 compute 나 for 메소드를 직접 호출 할 수 있다.
*   순차 코드에서 병렬 계산을 시작할 때만 invoke 를 사용한다.
* - 서브태스크에서 fork 메소드를 호출해서 ForkJoinPool 의 일정을 조절할 수 있다. 왼쪽 작업과 오른쪽 작업 모두 fork 메소드를 호출 하는것이
*   아니라 한쪽에만 fork 메소드를 호출하고 한쪽에는 compute 메소드를 호출하는것이 두 서브태스크의 한 태스크에는 같은 스레드를 재사용 할 수
*   있으므로 풀에서 불필요한 태스크를 할당하는 오버헤드를 피하여 효율적이다.
* - 포크/조인 프레임워크를 이용하는 병렬계산은 디버깅하기 어렵다. fork 라 불리는 다른 스레드에서 compute 를 호출 하므로 스택트레이스가
*   도움이 되지 않는다.
* - 멀티코어에 포크/조인 프레임워크를 사용하는것이 무조건 빠르다는 생각은 버려야한다. 병렬로 처리하려면 여러 독립적인 서브태스크로 분할 할 수
*   있어야 하는데 서브태스크의 실행시간은 새로운 태스크를 포킹하는데 드는 시간보다 길어야한다. ( 작업시간보다 포킹하는데 오래걸리면 안된다는 뜻 )
* */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;

    private final int start;

    private final int end;

    private static final long THRESHOLD = 10_000; // 해당 값 이하의 서브태스크는 더이상 분할 할 수 없다.

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start; // 이 태스크에서 더할 배열의 길이
        if (length <= THRESHOLD) {
            return computeSequentially(); // 기준값과 같거나 작으면 순차적으로 결과를 계산한다.
        }

        ForkJoinSumCalculator leftTask = // 배열의 첫 번째 절반을 더하도록 서브태스크를 생성한다.
                new ForkJoinSumCalculator(numbers, start, start + (length / 2));
        leftTask.fork(); // ForkJoinPool 의 다른 스레드로 새로 생성한 태스크를 비동기로 실행한다.

        ForkJoinSumCalculator rightTask = // 배열의 나머지 절반을 더하도록 서브태스크를 생성한다.
                new ForkJoinSumCalculator(numbers, start + (length / 2), end);

        long rightValue = rightTask.compute(); // 두번째 서브태스크를 동기 실행한다. 이때 추가로 분할이 일어날 수 있다.
        long leftValue = leftTask.join(); // 철번째 서브태스크의 결과를 읽거나 아직 결과가 없으면 기다린다.

        return leftValue + rightValue;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);

        /*
        * 일반적으로 ForkJoinPool 은 한번만 인스턴스화 해서 싱글턴으로 사용한다.
        * 기본 생성자를 사용하면 Runtime.availableProcessors 의 반환값으로 풀에 사용할 스레드 수를 결정한다.
        * */
        return new ForkJoinPool().invoke(task);
    }
}
