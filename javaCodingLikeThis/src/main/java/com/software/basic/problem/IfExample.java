package com.software.basic.problem;

/**
 * 1-2 연관된 조건문은 하나로 통합한다.
 * CollapsibleIfStatements - 조건문이 서로 연관성이 있으면 하나로 통합하는 것을 권고
 * */
public class IfExample {
    public static void main(String[] args) {
        badCode();
        goodCode();
    }

    /**
     * 연관된 조건문은 하나의 조건무느로 통합하는것이 가독성이 높아지고 스파케티 코드를 방지하는데 도움이 된다.
     * */
    private static void goodCode() {
        int num = 7;
        if (num > 4 && num < 10) {
            System.out.println(num + "은 4보다 크고 10보다 작다");
        }
    }

    private static void badCode() {
        // 잘못된 if 문 사용으로 스파게티 코드가 만들어지는 과정
        int num = 7;

        // 최초 조건
        if (num > 4) {
            System.out.println(num + "은 4보다 크다");
        }

        // 1차 요구사항
        if (num > 4) {
            if (num < 10) {
                System.out.println(num + "은 4보다 크고 10보다 작다");
            }
        }

        // 2차 요구사항
        if (num > 4) {
            if (num < 10) {
                System.out.println(num + "은 4보다 크고 10보다 작다");
            } else if (num > 11) {
                System.out.println(num + "은 11보다 크다");
            }
        }
    }
}
