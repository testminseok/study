package com.software.basic.solution.pool;

public class RunnableThread implements Runnable {
    private int threadNum;

    public RunnableThread(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("실행 가능한 스레드 [" + threadNum + "]");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
