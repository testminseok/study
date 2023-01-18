package com.software.basic.problem;

/**
 * 1-1 뒤죽박죽 증감변수
 * */
public class LoopExample {

    public static void main(String[] args) {
//        infinityLoop();
        infinityLoopSolution();
        infinityLoopSolution2();
        infinityLoopSolution3();
    }

    // badCode
    public static void infinityLoop() {
        for(int i =2; i <10; i++) {
            /*
             * 아래 코드를 자세히 보면 j 가 아닌 i 를 잘못 사용하여 발생하는 논리적 버그지만
             * 정상적으로 컴파일이 되며 실제 프로그램을 실행하면 무한루프로 빠진다.
             * */
            for(int j=1; j < 10; i++) {
                System.out.println(i + " X " +j +" = " + i*j);
            }
        }
    }

    /**
     * 단순히 오류 현상만 해결한 방법
     * */
    public static void infinityLoopSolution() {
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(i + " X " + j + " = " + i * j);
            }
        }
    }

    /**
     * 증감변수의 이름을 단순한 문자가 아닌 변수 명명 규칙에 따라 작명해 혼란을 방지
     * */
    public static void infinityLoopSolution2() {
        for (int preNum = 2; preNum < 10; preNum++) {
            for (int postNum = 1; postNum < 10; postNum++) {
                System.out.println(preNum + " X " + postNum + " = " + preNum * postNum);
            }
        }
    }

    /**
     * 기존과 같이 한 문자의 증감변수를 사용하지만 i 와 j 같이 혼동할 가능성이 있는 문자가 아닌
     * i 와 k 같은 문자를 사용해 혼란을 방지
     * */
    public static void infinityLoopSolution3() {
        for (int i = 2; i < 10; i++) {
            for (int k = 1; k < 10; k++) {
                System.out.println(i + " X " + k + " = " + i * k);
            }
        }
    }
}
