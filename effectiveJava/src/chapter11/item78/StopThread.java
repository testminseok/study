package chapter11.item78;

import java.util.concurrent.TimeUnit;

/**
 * 여러 스레드가 가변 데이터를 공유한다면 그 데이터를 읽고 쓰는 동작은 반드시 동기화 해야한다.
 * 동기화하지 않으면 한 스레드가 수행한 변경을 다른 스레드가 보지 못할 수도 있다.
 * 공유되는 가변 데이터를 동기화하는 데 실패하면 응답 불가 상태에 빠지거나 안전 실패로 이어질 수 있다.
 * 이는 디버깅 난이도가 가장 높은 문제에 속한다.
 * 간헌적이거나 특정 타이밍에만 발생할 수도 있고, VM에 따라 현상이 달라지기도 한다.
 * 배타적 실행은 필요 없고 스레드끼리의 통신만 필요하다면 volatile 한정자만으로 동기화할 수 있다.
 * 다만 올바로 사용하기가 까다롭다.
 * */
public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        /*
        * 메인 스레드가 수정한 값을 백그라운드 스레드가 언제쯤에나 보게 될지 보증할 수 없다.
        * 그러므로 해당 스레드가 종료되지 않는다. 또한 동기화가 빠지면 가상머신이 다음과 같은 최적화를 수행할 수도 있다.
        * while (!stopRequested)
        *    i++;
        * 를
        * if (!stopRequested)
        *    while (true)
        *       i++;
        * OpenJDK 서버 VM이 실제로 적용하는 끌어올리기(hoisting) 최적화이다.
        * */
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
