package com.software.basic.solution.pool;

import java.util.concurrent.*;

public class NewCachedThreadPoolExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // cached thread pool 생성
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 실행 가능한 스레드 실행
        executorService.execute(new RunnableThread(0));
        executorService.execute(new RunnableThread(1));

        // 호출 가능한 스레드 시작
        Future<Integer> future = executorService.submit(new CallableThread(2));

        // 호출 가능한 스레드의 값 가져오기
        int value = future.get();
        System.out.println("호출 가능한 스레드의 값 : " + value);

        boolean isTerminated = executorService.isTerminated();
        System.out.println("스레드 풀 종료 여부 : " + isTerminated);

        // 스레드 풀의 스레드가 종료되기까지 30초 기다린다.
        executorService.awaitTermination(30, TimeUnit.SECONDS);

        // 스레드 풀 종료
        executorService.shutdown();
    }
}
