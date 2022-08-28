package f.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinSample {
    static final ForkJoinPool mainPool = new ForkJoinPool();

    public static void main(String[] args) {
        /*
        * Fork/Join 은 복잡한 연산을 여러 쓰레드에서 사용하기 위해 만든것이며, 계산이 복잡할 수록 효과가 크다.
        * 또한 개발자가 별도로 쓰레드를 관리할 필요 없이 JVM 에서 알아서 수행한다.
        *
        * Fork/Join 은 보통 회귀적으로 수행될때 많이 사용된다.
        * RecursiveAction 과 RecursiveTask 라는 클래스를 상속받아 구현하여
        * ForkJoinPoll 클래스로 작업을 시작한다.
        * */
        ForkJoinSample sample = new ForkJoinSample();
        sample.calculate();
    }

    private void calculate() {
        long from = 0;
        long to = 10;

        GetSum sum = new GetSum(from, to);
        Long result = mainPool.invoke(sum);
        System.out.println("Fork Join:Total sum of " + from + " ~ " + to + " = " + result);
    }
}
