package com.software.basic.problem;

/**
 * 11-9 스레드 그룹은 사용하지 않는다.
 * - AvoidThreadGroup : 스레드 그룹의 사용을 경고하고 다른 기능을 사용하도록 권고한다.
 *                      스레드 그룹은 스레드 환경에서 사용하기 위한것이지만 스레드로부터 안전하지 않은 메소드를 포함한다.
 *                      (다른 기능이란 자바 1.5부터 제공되는 실행자(Executor)와 스레드 풀(thread pool)로 구성된
 *                      실행자 프레임워크(Executor Framework)를 사용하는 것을 의미한다.)
 * */
public class ThreadGroupExample implements Runnable {
    public static void main(String[] args) {
        ThreadGroupExample example = new ThreadGroupExample();
        example.func();
    }

    public void func() {
        try {
            // 부모 집합 생성
            ThreadGroup parentGroup = new ThreadGroup("ParentGroup");

            // 자식 집합 생성
            ThreadGroup childGroup = new ThreadGroup(parentGroup, "ChildGroup");

            // 부모 집합의 스레드 생성
            Thread parentGroupThread = new Thread(parentGroup, this);
            System.out.println(parentGroupThread.getName() + " 시작");
            parentGroupThread.start();

            // 자식 집합의 스레드 생성
            Thread childGroupThread = new Thread(childGroup, this);
            System.out.println(childGroupThread.getName() + " 시작");
            childGroupThread.start();

            // 자식 집합의 스레드 생성
            Thread childGroupThread2 = new Thread(childGroup, this);
            System.out.println(childGroupThread2.getName() + " 시작");
            childGroupThread2.start();

            Thread[] list = new Thread[parentGroup.activeCount()];
            int count = parentGroup.enumerate(list);

            // 부모 집합에 있는 모든 스레드를 출력한다.
            for (int i = 0; i < count; i++) {
                System.out.println(list[i].getName());
            }

            // 다른 스레드가 끝날 때까지 기다린다.
            parentGroupThread.join();
            childGroupThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 종료");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
