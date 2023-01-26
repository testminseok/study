package com.software.basic.problem;

import java.math.BigDecimal;

/**
 * 1-11 BigDecimal 의 함정
 * - AvoidDecimalLiteralsInBigDecimalConstructor : BigDecimal 의 생성자에 실수를 통해 인스턴스화 하지 못하도록 한다.
 */
public class BigDecimalExample {
    public static void main(String[] args) {

        bigDecimalExample();
        bigDecimalConstructExample();
        bigDecimalEqualsAndCompareTo();
    }

    private static void bigDecimalEqualsAndCompareTo() {
        /*
         * BigDecimal 의 값을 비교할 때는 equals 보다 compareTo 를 확용하자.
         * */
        BigDecimal bdValue3 = new BigDecimal("1");
        BigDecimal bdValue4 = new BigDecimal("1.00");
        BigDecimal bdValue5 = new BigDecimal(1.00);

        System.out.println(bdValue3.compareTo(BigDecimal.ONE) == 0); // true
        System.out.println(bdValue3.equals(BigDecimal.ONE)); // true

        System.out.println(bdValue3.compareTo(bdValue4) == 0); // true
        System.out.println(bdValue3.equals(bdValue4)); // false

        System.out.println(bdValue4.compareTo(bdValue5) == 0); // true
        System.out.println(bdValue4.equals(bdValue5)); // false

        System.out.println(bdValue4.compareTo(BigDecimal.ONE) == 0); // true
        System.out.println(bdValue4.equals(BigDecimal.ONE)); // falseZ
    }

    private static void bigDecimalConstructExample() {
        // 정수값을 이용한 선언
        BigDecimal bdValue = new BigDecimal(12);

        // 실수를 이용한 선언
        BigDecimal bdValue2 = new BigDecimal(1.123);

        /*
        * 정수를 이용해 BigDecimal 을 생성한 객체는 오류 없이 정확한 값으로 객체를 생성할 수 있지만
        * 실수를 이용해 생성하면 원래 1.123 이 아닌 근사치인 1.1229999999999999982236431605997495353221893310546875 로 생성되는
        * 문제가 발생한다.
        *
        * 때문에 BigDecimal 객체를 실수가 아닌 String 형태로 생성하거나 valueOf 메소드를 사용하는것으로 문제를 해결할 수 있다.
        * */
        System.out.println(bdValue); // 12
        System.out.println(bdValue2); // 1.1229999999999999982236431605997495353221893310546875
        System.out.println(new BigDecimal("1.123")); // 1.123
        System.out.println(BigDecimal.valueOf(1.123)); // 1.123
    }

    private static void bigDecimalExample() {
        /*
        * double 을 이용해 계산할 경우 정확한 값을 계산할 수 없다.
        * */
        double dValue = 4.7;
        double dValue2 = 0.4;
        System.out.println("double 을 이용한 값 계산의 예 : " + dValue + " + " + dValue2 + " = " + (dValue + dValue2));

        /*
        * BigDecimal 을 이요할 경우 정확한 소수점 계산 결과를 얻을 수 있다.
        * */
        BigDecimal bdValue = new BigDecimal("4.7");
        BigDecimal bdValue2 = BigDecimal.valueOf(0.4);
        System.out.println("BigDecimal 을 이용한 값 계산의 예 : " + bdValue + " + " + bdValue2 + " = " + (bdValue.add(bdValue2)));
    }
}
