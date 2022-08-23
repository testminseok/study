package e.thread.support;

public class SleepThread extends Thread {
    private long sleepTime;

    public SleepThread(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            System.out.println("Sleeping" + getName());
            Thread.sleep(sleepTime);
            System.out.println("Sleeping" + getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
