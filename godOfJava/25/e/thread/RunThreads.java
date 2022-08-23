package e.thread;

public class RunThreads {
    public static void main(String[] args) {
        RunThreads runThreads = new RunThreads();
        runThreads.runBasic();
    }

    public void runBasic() {
        /*
            Runnable interface 를 구현한 클래스를 Thread 클래스의 생성자로 전달해준다.
            run() 메서드에서 실행할 일련의 목록을 작성하지만 , 실행은 start() 메소드를 호출한다.

            Runnable interface 를 사용하는 이유는 Thread 클래스를 상속하여 확장받으려는 클래스가
            이미 다른 클래스를 상속받고 있을경우 Runnable interface 를 사용한다.

            Thread 가 종료될때까지 자바프로세스는 종료되지 않는다. 하지만 데몬 쓰레드는 예외이다.
         */
        RunnableSample runnable = new RunnableSample();
        new Thread(runnable).start();

        ThreadSample thread = new ThreadSample();
        new Thread(thread).start();

        System.out.println("RunThreads.runBasic() method is ended");
    }
}
