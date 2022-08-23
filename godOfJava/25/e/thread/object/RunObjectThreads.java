package e.thread.object;

public class RunObjectThreads {
    public static void main(String[] args) {
        RunObjectThreads runObjectThreads = new RunObjectThreads();
//        runObjectThreads.checkThreadState2();
        runObjectThreads.checkThreadState3();
    }

    public void checkThreadState2() {
        Object monitor = new Object();
        StateThread stateThread = new StateThread(monitor);

        try {
            System.out.println("thread state = " + stateThread.getState());
            stateThread.start();
            System.out.println("thread state (after start) = " + stateThread.getState());

            Thread.sleep(1000);
            System.out.println("thread state (after 0.1 sec) = " + stateThread.getState());

            synchronized (monitor) {
                monitor.notify();
            }

            Thread.sleep(1000);
            System.out.println("thread state (after notify) = " + stateThread.getState());

            stateThread.join();
            System.out.println("thread state (after join) =" + stateThread.getState());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkThreadState3() {
        Object monitor = new Object();
        StateThread stateThread = new StateThread(monitor);
        StateThread stateThread2 = new StateThread(monitor);

        try {
            System.out.println("thread state = " + stateThread.getState());
            stateThread.start();
            stateThread2.start();
            System.out.println("thread state (after start) = " + stateThread.getState());

            Thread.sleep(1000);
            System.out.println("thread state (after 0.1 sec) = " + stateThread.getState());

            synchronized (monitor) {
                /*
                *  monitor 객체로 대기중인 쓰레드를 notify() 메소드를 호출하여 쓰레드를 다시 실행시킬때는 가장먼저 대기중인 쓰레드 1개만
                * 실행시킨다. 이러한 경우처럼 monitor 객체가 몇개에 쓰레드를 wait 시키고 있는지 모른다면 notifyAll() 을 사용한다.
                * */
//                monitor.notify();
                monitor.notifyAll();
            }

            Thread.sleep(1000);
            System.out.println("thread state (after notify) = " + stateThread.getState());

            stateThread.join();
            System.out.println("thread state (after join) =" + stateThread.getState());
            stateThread2.join();
            System.out.println("thread2 state (after join) =" + stateThread2.getState());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
