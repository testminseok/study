package com.software.basic.problem.string;

/**
 * 4-7 문자열에서 특정 문자 찾기
 * - UseIndexOfChar : indexOf 메소드를 사용할때 매개변수로 단일 문자열을 사용할때 indexOf(String) 이 아닌 indexOf(char)로 수정하길 권고한다.
 */
public class IndexOfExample {
    public static void main(String[] args) {
        String str = "0123456789abcdef0123456789abcdef";

        System.out.println("문자 a는 " + str.indexOf("a") + "번째 위치한다.");
        System.out.println("문자 abc는 " + str.indexOf("abc") + "번째 위치한다.");
        System.out.println("15번째 문자 이후부터 찾은 문자 a는 " + str.indexOf("a") + "번째 위치한다.");
        System.out.println("15번째 문자 이후부터 찾은 문자 abc는 " + str.indexOf("abc") + "번째 위치한다.");
    }
}
