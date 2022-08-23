package e.thread;

public class RunDaemonThreads {
    public static void main(String[] args) {
        /*
            Daemon Thread 는 해당 쓰레드가 종료되지 않더라도 다른 실행중인 쓰레드가 없다면 멈춘다.
         */
        RunDaemonThreads runDaemonThreads = new RunDaemonThreads();
//        runDaemonThreads.checkThreadProperty();
//        runDaemonThreads.runCommonThread();
        runDaemonThreads.runDaemonThread();
    }

    public void runCommonThread() {
        DaemonThread thread = new DaemonThread();
        thread.start();
    }

    public void runDaemonThread() {
        DaemonThread thread = new DaemonThread();
        thread.setDaemon(true);
        thread.start();
    }

    public void checkThreadProperty() {
        ThreadSample thread1 = new ThreadSample();
        ThreadSample thread2 = new ThreadSample();
        ThreadSample daemonThread = new ThreadSample();

        System.out.println("thread1 id = " + thread1.getId());
        System.out.println("thread2 id = " + thread2.getId());

        System.out.println("thread1 name = " + thread1.getName());
        System.out.println("thread2 name = " + thread2.getName());

        System.out.println("thread1 priority = " + thread1.getPriority());

        daemonThread.setDaemon(true);

        System.out.println("thread1 isDaemon = " + thread1.isDaemon());
        System.out.println("daemonThread isDaemon = " + daemonThread.isDaemon());
    }
}
