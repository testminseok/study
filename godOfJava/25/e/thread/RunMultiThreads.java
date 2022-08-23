package e.thread;

public class RunMultiThreads {
    public static void main(String[] args) {
        RunMultiThreads runMultiThreads = new RunMultiThreads();
        runMultiThreads.runMultiThread();
    }

    public void runMultiThread() {
        /*
            Thread 의 종료순서는 불분명하다.
            하지만 Thread 가 작업중인 동안 자바 프로세서는 종료되지 않는다. 하지만 데몬 쓰레드는 예외이다.
         */
        RunnableSample[] runnable = new RunnableSample[5];
        ThreadSample[] thread = new ThreadSample[5];

        for (int i = 0; i < 5; i++) {
            runnable[i] = new RunnableSample();
            thread[i] = new ThreadSample();

            new Thread(runnable[i]).start();
            thread[i].start();
        }

        System.out.println("RunMultiThreads.runMultiThread() method is ended.");
    }
}
