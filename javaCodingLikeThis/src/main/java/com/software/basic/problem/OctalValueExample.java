package com.software.basic.problem;

/**
 * 1-12 8진수 값은 사용하지 않는다.
 * - AvoidUsingOctalValues : 8진수 사용을 제한한다.
 */
public class OctalValueExample {
    public static void main(String[] args) {
        octalValueExample();
        octalValueExample2();
    }

    /**
     * 8진수나 16진수 모두 특정 라이브러리에서 필요하거나 요구사항에 따라 꼭 써야만 하는 상황이 아니라면 최대한 사용하지 않는 것이 좋다.
     * 반드시 사용해야 하더라도 선언하거나 연산할때는 10진수를 사용하고 값을 출력할 때만 String.format 등을 이용해 출력하는 방법으로
     * 개발자의 실수를 최대한 줄이는 것이 좋다.
     * */
    private static void octalValueExample2() {
        /*
        * 아래 두 변수는 분명 다른 값이지만
        * 같은 값으로 혼동될 수 있다.
        * */
        int decValue = 10;
        int octValue = 010; // octValue 의 값은 10이 아닌 8이다.
        System.out.println(String.format("10진수로 변환한 값 : decValue = %d | octValue = %d", decValue, octValue));

        /*
        * 아래 두 변수 또한 10진수로 오인할 가능성이 높다.
        * */
        int octNum = 012;
        int octNum2 = 010;
        System.out.println(String.format("결과는 120이 아닌 %d 이다", octNum * octNum2));
    }

    private static void octalValueExample() {
        // 16진수
        int hexValue = 0xFF;
        // 10진수
        int decValue = 98;
        // 8진수
        int octValue = 076;

        /*
        * 각 변수가 다른 진법으로 선언돼 있지만 진법 간 변환과 계산이 가능하다.
        * */
        System.out.println(String.format("hexValue 의 16진수 값 : %x\t|\t10진수 값 : %d\t|\t8진수 값 : %o", hexValue, hexValue, hexValue));
        System.out.println(String.format("hexValue 의 16진수 값 : %x\t|\t10진수 값 : %d\t|\t8진수 값 : %o", decValue, decValue, decValue));
        System.out.println(String.format("hexValue 의 16진수 값 : %x\t|\t10진수 값 : %d\t|\t8진수 값 : %o", octValue, octValue, octValue));
        System.out.println("모든 값의 합 : " + (hexValue + decValue + octValue));
    }
}
