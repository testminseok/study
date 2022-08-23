package e.thread.support;

public class RunSupportThreads {
    public static void main(String[] args) {
        RunSupportThreads runSupportThreads = new RunSupportThreads();
        runSupportThreads.checkThreadState1();
    }

    public void checkJoin() {
        SleepThread thread = new SleepThread(2000);
        try {
            thread.start();
            thread.join(500);
            thread.interrupt();

            System.out.println("thread state (after join) = " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkThreadState1() {
        SleepThread sleepThread = new SleepThread(2000);
        try {
            System.out.println("thread state = " + sleepThread.getState());
            sleepThread.start();
            System.out.println("thread state(after start) = " + sleepThread.getState());

            Thread.sleep(1000);
            System.out.println("thread state(after 1 sec) = " + sleepThread.getState());

            sleepThread.join();
            sleepThread.interrupt();

            System.out.println("thread state(after join) = " + sleepThread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
