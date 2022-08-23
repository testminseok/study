package e.thread.group;

import e.thread.support.SleepThread;

public class RunGroupThreads {
    public static void main(String[] args) {
        RunGroupThreads runGroupThreads = new RunGroupThreads();
        runGroupThreads.groupThread();
    }

    public void groupThread() {
        try {
            SleepThread sleepThread1 = new SleepThread(5000);
            SleepThread sleepThread2 = new SleepThread(5000);

            ThreadGroup threadGroup = new ThreadGroup("Group1");
            Thread thread1 = new Thread(threadGroup, sleepThread1);
            Thread thread2 = new Thread(threadGroup, sleepThread2);

            thread1.start();
            thread2.start();
            Thread.sleep(1000);
            System.out.println("Group name = " + threadGroup.getName());

            int activeCount = threadGroup.activeCount();
            System.out.println("Active count = " + activeCount);
            threadGroup.list();

            Thread[] tempThreadList = new Thread[activeCount];
            int result = threadGroup.enumerate(tempThreadList);
            System.out.println("Enumerate result = " + result);
            for (Thread thread : tempThreadList) {
                System.out.println(thread);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
