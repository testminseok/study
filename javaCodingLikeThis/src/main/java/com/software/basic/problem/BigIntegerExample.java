package com.software.basic.problem;

import java.math.BigInteger;

/**
 * 1-10 BigInteger 객체의 사용법
 * - BigIntegerInstantiation : BigInteger 객체의 인스턴스화를 진단하고 수정하도록 권고한다.
 */
public class BigIntegerExample {
    public static void main(String[] args) {
        bacCode();
        goodCode();
    }

    private static void goodCode() {
        BigInteger biZero = BigInteger.ZERO;
        BigInteger biOne = BigInteger.ONE;
        BigInteger biTen = BigInteger.TEN;

        /*
        * 정의 되지 않은 값은 생성자를 이용해서 인스턴스화 한다.
        * */
        BigInteger bigInteger = new BigInteger("10000000");
        BigInteger bigInteger1 = BigInteger.valueOf(20_000_000);

        System.out.println(biZero.intValue() + biOne.intValue() + biTen.intValue() +
                bigInteger.intValue() + bigInteger1.intValue());
    }

    /**
     * BigInteger 는 자주사용하는 숫자들을 상수로 정의해놓았다.
     * 때문에 0, 1, 10 은 상수를 통해 인스턴스 객체를 생성한다.
     * */
    private static void bacCode() {
        BigInteger biZero = new BigInteger("0");
        BigInteger biOne = BigInteger.valueOf(1);
        BigInteger biTen = new BigInteger("10");

        System.out.println(biZero.intValue() + biOne.intValue() + biTen.intValue());
    }
}
