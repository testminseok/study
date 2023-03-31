package com.software.optimize.solution.immutable;

import java.math.BigDecimal;

public class ImmutableObjectExample {
    public static void main(String[] args) {
        String str = "test";
        System.out.println("변경 전 문자열 : " + str);

        // 문자열을 대문자로 변경하는 메소드 실행
        // 대문자로 변경된 새로운 문자열을 생성해서 반환한다.
        str = str.toUpperCase();
        System.out.println("변경 후 문자열 : " + str);

        BigDecimal big = new BigDecimal(10);
        System.out.println("변경 전 BigDecimal 값 : " + big);

        // 불변 객체인 BigDecimal 에 값을 더해도 초기에 설정된 내부 값은 변하지 않는다.
        // 기존 값인 10과 20을 더한 새로운 BigDecimal 객체를 생성해서 반환한다.
        big = big.add(new BigDecimal(20));
        System.out.println("변경 후 BigDecimal 값 : " + big);
    }
}
