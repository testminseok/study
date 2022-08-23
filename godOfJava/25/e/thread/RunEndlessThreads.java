package e.thread;

public class RunEndlessThreads {
    public static void main(String[] args) {
        /*
        * Thread 가 실행중일때는 자바프로세스가 종료되지않는다.
        * */
        RunEndlessThreads runEndlessThreads = new RunEndlessThreads();
        runEndlessThreads.endless();
    }

    public void endless() {
        EndlessThread thread = new EndlessThread();

        thread.start();
    }
}
