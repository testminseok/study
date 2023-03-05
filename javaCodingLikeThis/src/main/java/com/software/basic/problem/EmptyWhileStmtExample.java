package com.software.basic.problem;

/**
 * 7-3 비어있는 반복문은 불필요한 시스템 자원을 소비한다.
 * - EmptyWhileStmt : 비어있는 while 문이 있을경우 수정을 권고한다. 지연시간이 필요할경우 Thread.sleep() 를 사용해야한다.
 *                    (Deprecated EmptyControlStatement 에 병합됨)
 * - EmptyControlStatement : 비어있는 제어문과 초기화 블럭이 있을경우 수정을 권고한다.
 */
public class EmptyWhileStmtExample {
    public static void main(String[] args) {

        // 시작시간
        System.out.println("시작");
        long startTime = System.currentTimeMillis();
        int i = 0;
        while (i++ < 1000000) {

        }

        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("종료 [소요시간 : " + time + " ms]");

        System.out.println("시작");
        startTime = System.currentTimeMillis();
        i = 0;
        while (i++ < 1000000) {

        }
        endTime = System.currentTimeMillis();
        time = endTime - startTime;
        System.out.println("종료 [소요시간 : " + time + " ms]");

    }
}
