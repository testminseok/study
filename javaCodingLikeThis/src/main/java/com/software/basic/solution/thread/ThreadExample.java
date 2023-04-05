package com.software.basic.solution.thread;

/**
 * 11-10 Thread 의 run 메소드 대신 start 메소드를 사용한다.
 * DontCallThreadRun : Thread 의 run 메소드를 사용하는 경우 수정을 권고한다.
 *                     스레드의 run 메소드를 호출하면, 스레드가 아닌 호출자의 제어 스레드에서 실행된다.
 *                     즉, 일반 메소드로 동작한다.
 * */
public class ThreadExample {
    public static void main(String[] args) {
        Runnable runnable = new ThreadRunSample();
        Thread thread = new Thread(runnable);
        System.out.println("스레드 호출 시작");
        thread.start();
        System.out.println("스레드 호출 종료");
    }
}
