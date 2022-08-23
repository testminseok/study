package e.thread.practice;

import java.util.Date;

public class TimerThread extends Thread {
    @Override
    public void run() {
        printCurrentTime();
    }

    public void printCurrentTime() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000 - (System.currentTimeMillis() % 1000));

                Date date = new Date();
                System.out.println(date + " " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
