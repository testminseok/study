package com.software.basic.problem;

/**
 * 1-4 잘못된 null 비교
 * - BrokenNullCheck : NullPointException 이 발생할 수 있는 null 조건 비교를 확인할 수 있다.
 * */
public class NullCheckExample {
    public static void main(String[] args) {
        String a = "abcde";
        String b = null;

        System.out.println(isNull(a));
//        System.out.println(isNull(b)); // NPE

        System.out.println(isNull2(a));
//        System.out.println(isNull2(b)); // NPE
    }

    /**
     * 잘못된 null 비교 메소드
     * */
    private static boolean isNull2(String value) {

        /*
        * value 의 값이 null 이라도 value.equals("") 이 실행되어
        * NullPointException 이 발생한다.
        * 이 같은 상황에서 올바른 논리 연산자는 || 가 아닌 && 이다.
        * */
        if (value != null || !value.equals("")) {
            return false;
        }

        return true;
    }

    /**
     * 잘못된 null 비교 메소드
     * */
    private static boolean isNull(String value) {
        /*
         * value 값이 null 이 아닐 때만 value.equals("") 이 실행돼야 하는데
         * 이 같은 상황에서 올바른 논리연산자는 && 가 아닌 || 여야한다.
         */
        if (value == null && value.equals("")) {
            return true;
        }

        return false;
    }
}