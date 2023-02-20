package com.software.basic.problem.string;

/**
 * 4-4 대문자를 포함한 문자열
 * UnnecessaryCaseChange : 두 문자열이 동일하지 비교할 때 toUpperCase/toLowerCase 메소드를 호풀할때 수정을 권고한다.
 *                          (대문자 또는 소문자 문자열로 변환할 때 각 문자를 변경하기 위해 메소드 내부에서 임시 char 배열과 같은
 *                          인스턴스를 생성하기 때문에 대규모 시스템에선 메모리가 낭비될 여지가 있다.)
 */
public class WrongUpperOrLowerCaseCompareExample {
    public static void main(String[] args) {
        String value = "abcDEF";
        String value2 = "ABCdef";

        badCode(value, value2);
        goodCode(value, value2);
    }

    private static void goodCode(String value, String value2) {
        /*
        * 대소문자의 구분없이 문자열의 동일성을 확인할 수 있는 equalsIgnoreCase 를 사용한다.
        * */
        if (value.equalsIgnoreCase(value2)) {
            System.out.println("value & value2 는 같다");
        }
    }

    private static void badCode(String value, String value2) {
        // 모든 문자를 대문자로 변환한 후 비교
        if (value.toUpperCase().equals(value2.toUpperCase())) {
            System.out.println("value & value2 는 같다");
        }

        // 모든 문자를 소문자로 변환한 후 비교
        if (value.toLowerCase().equals(value2.toLowerCase())) {
            System.out.println("value & value2 는 같다");
        }
    }
}
