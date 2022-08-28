package f.forkjoin;

import java.util.concurrent.RecursiveTask;

public class GetSum extends RecursiveTask<Long> {
    private long from;
    private long to;

    public GetSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        long gap = to - from;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log("From = " + from + " To = " + to);

        if (gap <= 3) {
            long tempSum = 0;

            for (long i = from; i <= to; i++) {
                tempSum += i;
            }
            log("Return !! " + from + " ~ " + to + " = " + tempSum);
            return tempSum;
        }

        long middle = (from + to) / 2;
        GetSum sumPre = new GetSum(from, middle);

        log("Pre From = " + from + " To = " + middle);

        sumPre.fork();
        GetSum sumPost = new GetSum(middle + 1, to);

        log("Post From = " + (middle + 1) + " To = " + to);

        return sumPost.compute() + sumPre.join();

    }

    private void log(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] " + message);
    }
}
