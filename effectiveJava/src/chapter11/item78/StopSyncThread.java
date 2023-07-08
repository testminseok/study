package chapter11.item78;

import java.util.concurrent.TimeUnit;

public class StopSyncThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested()) {
                i++;
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }

    /**
     * 쓰기와 읽기 모두가 동기화되지 않으면 동작을 보장하지 않는다.
     * */
    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }
}
