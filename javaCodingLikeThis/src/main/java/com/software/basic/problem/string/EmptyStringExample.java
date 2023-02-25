package com.software.basic.problem.string;

/**
 * 4-8 빈 문자열
 * - InefficientEmptyStringCheck : 문자열이 비어있는지 확인할 때 String.trim().length() == 0 또는 String.trim().isEmpty() 를
 *                                 사용해 비교할 경우 수정을 권고한다.
 */
public class EmptyStringExample {
    public static void main(String[] args) {
        String empty = " ";

        badCode(empty);
        if (isBlank(empty)) {
            System.out.println("empty String");
        } else {
            System.out.println("not empty String");
        }
    }

    private static boolean isBlank(String str) {
        /*
        * Character.isWhitespace 를 활용하면 불필요한 인스턴스 생성을 피하고
        * 더욱 정확한 공백문자를 확인할 수 있다.
        *
        * 아래의 메소드로 대채할 수 있다.
        * Apache's StringUtils#isBlank
        * Spring's StringUtils#hasText
        * Google's CharMatcher#whitespace
        * */
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))){
                return false;
            }
        }

        return true;
    }

    private static void badCode(String empty) {
        /*
        * trim 과 length 메소드를 이용한 방식은 불필요한 인스턴스가 생성될 뿐더러
        * isWhiteSpace 메소드보다 정확도가 떨어진다.
        * */
        if (empty.trim().length() == 0) {
            System.out.println("empty String");
        } else {
            System.out.println("not empty String");
        }
    }
}
