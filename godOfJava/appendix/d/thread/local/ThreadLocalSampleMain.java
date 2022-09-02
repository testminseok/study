package d.thread.local;

public class ThreadLocalSampleMain {
    public static void main(String[] args) {
        /*
        * ThreadLocal
        * - 저장된 값은 해당 쓰레드에서 고유하게 사용할 수 있다.
        * - 클래스의 변수는 private static final 로 선언한다.
        * - 사용이 끝난 후에는 remove() 메소드를 호출해주는 습관을 가져야한다.
        * 웹 기반 어플리케이션에서는 Thread 를 재사용하기 위해서 Thread Pool 이라는 것을 사용하는데
        * 이 Thread Pool 을 사용하면 쓰레드가 시작 된 후에 그냥 끝나는 것이 아니기 때문에 remove() 메소드를 사용하여 값을 지워줘야지만
        * 해당 쓰레드를 다음에 재사용할때  쓰레기 값이 들어있지 않다.
        * */
        ThreadLocalSampleMain main = new ThreadLocalSampleMain();
        main.start();
    }

    private void start() {
        new LocalUserThread().start();
        new LocalUserThread().start();
        new LocalUserThread().start();
    }
}
