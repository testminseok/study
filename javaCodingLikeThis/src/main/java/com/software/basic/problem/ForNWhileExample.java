package com.software.basic.problem;

import java.util.Scanner;

/**
 * 1-6 for 문 vs while 문
 * - ForLoopShouldBeWhileLoop : 일부 for Loop 는 while Loop 로 단순화 할 수 있어 간결해진다.
 * - PWD 에서는 단순히 조건 초기화 및 증감식이 필요없다면 while 을 사용하는 것을 권고한다.
 */
public class ForNWhileExample {
    public static void main(String[] args) {
        forExample();
        whileExample();
        unreadableForExample();
    }

    /**
     * 가독성이 좋지 않은 for 문의 예
     * */
    private static void unreadableForExample() {
        String pwd = "password";
        Scanner scanner = new Scanner(System.in);

        /*
        * for(;true;) 문은 초기화식과 증감식이 없는 구조로서
        * for 문을 잘못 사용하는 것으로 오인될 수 있으며, 코드의 가독성도 떨어진다.
        * */
        for (;true;) {
            System.out.println(" 암호를 입력하세요 : ");
            if (pwd.equals(scanner.next())) {
                System.out.println("암호 확인");
                break;
            }
        }

        scanner.close();
    }

    /**
     * 일반적인 while 문의 예
     * */
    private static void whileExample() {
        String pwd = "password";
        Scanner scanner = new Scanner(System.in);

        // 특정 조건에 따라 제어해야 하는 반복문에는 while 를 사용하자
        while (true) {
            System.out.println(" 암호를 입력하세요 : ");
            if (pwd.equals(scanner.next())) {
                System.out.println("암호 확인");
                break;
            }
        }

        scanner.close();
    }

    /**
     * 일반적인 for 문의 예
     * */
    private static void forExample() {
        // 범위가 정해진 반복문에는 for 를 사용하자
        for (int i = 1; i < 10; i++) {
            System.out.println("2 * " + i + " = " + 2 * i);
        }
    }
}
