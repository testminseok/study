package com.software.basic.problem;

/**
 * 9-2 switch 문에서 break 는 필수다.
 * - ImplicitSwitchFallThrough : 각 case 에 대해 break 또는 return 이 없는 switch 문이 있는 경우 수저을 권고한다.
 *                               (MissingBreakInSwitch 에서 이름이 변경 되었다.)
 */
public class MissingBreakInSwitchExample {
    private static final int LOGIN = 0;
    private static final int LOGOUT = 1;
    private static final int SIGN_IN = 2;
    private static final int SIGN_OUT = 3;

    public static void main(String[] args) {
        int key = args != null ? Integer.parseInt(args[0]) : 0;

        badCode(key);
        goodCode(key);
    }

    private static void goodCode(int key) {
        switch (key) {
            case LOGIN:
                System.out.println("로그인 되셨습니다.");
                break;
            case LOGOUT:
                System.out.println("로그아웃 되셨습니다.");
                break;
            case SIGN_IN:
                System.out.println("가입하셨습니다.");
                break;
            case SIGN_OUT:
                System.out.println("탈퇴하셨습니다.");
                break;
            default:
                break;
        }
    }

    private static void goodCode2(int key) {
        /*
        * 이런 방식으로 if 문을 사용하는 것이
        * badCode2에서 case 절을 중첩해서 사용하는 방법보다 정확하고 효율적이다.
        * 특히 switch 문은 각 경우의 수를 case 문으로 정의해야 하지만
        * if 문은 조건식을 기준으로 경우의 수를 설정할 수 있다.
        * */
        if (key % 2 == 0) {
            System.out.println(key + "는 짝수다");
        } else {
            System.out.println(key + "는 홀수다");
        }
    }

    private static void badCode(int key) {
        switch (key) {
            case LOGIN:
                System.out.println("로그인 되셨습니다.");
            case LOGOUT:
                System.out.println("로그아웃 되셨습니다.");
                break;
            case SIGN_IN:
                System.out.println("가입하셨습니다.");
            case SIGN_OUT:
                System.out.println("탈퇴하셨습니다.");
                break;
            default:
                break;
        }
    }

    /**
     * 여러 개의 case 절을 중첩해서 하나의 경우의 수로 처리하기도 하는데
     * 이런 방식은 나중에 시스템을 분석할 떄 변칙적인 switch 문의 사용으로 프로스세를 오인할 가능성이 매우 높은 위험한 방식이다.
     * */
    private static void badCode2(int key) {
        switch (key) {
            case 2:
            case 4:
                System.out.println(key + "는 짝수다");
                break;
            case 1:
            case 3:
                System.out.println(key + "는 홀수다");
                break;
            default:
                break;
        }
    }
}
