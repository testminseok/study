package com.software.basic.problem;

/**
 * 1-8 반복문 끝에는 분기문을 두지 않는다.
 * - AvoidBranchingStatementAsLastInLoop : Loop 의 마지막 분기문을 사용하는것은 해당 반복문을 무력화할 수 있다는 것을 경고한다.
 */
public class BranchingExample {
    public static void main(String[] args) {
        badCode();
        badCode2();
    }

    private static void badCode2() {
        int result = 0;
        // 잘못된 제어문과 예약어의 조합
        for (int i = 0; i < 10; i++) {
            if (i * i <= 25) {
                continue;
            }

            result = i * i;
            break;
        }

        System.out.println(result);
    }

    private static void badCode() {
        // 제어문과 break 문을 이용해 반목문을 종료시키는 예
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }

            break;
        }

        // 제어문과 return 문을 이요해 반복문과 메소드를 종료시키는 예
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }

            return;
        }
    }
}
