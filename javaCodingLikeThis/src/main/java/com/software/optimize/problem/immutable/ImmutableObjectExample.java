package com.software.optimize.problem.immutable;

import java.math.BigDecimal;

/**
 * 11-4 불변 객체는 객체 관리를 수월하게 만들어준다.
 *  - UselessOperationOnImmutable : 불변 객체의 내부 상태를 변경하기 위해서는 객체를 재등록하도록 권고한다.
 * */
public class ImmutableObjectExample {
    public static void main(String[] args) {
        String str = "test";
        System.out.println("변경 전 문자열 : " + str);

        // 문자열을 대문자로 변경하는 메소드 실행
        str.toUpperCase();
        System.out.println("변경 후 문자열 : " + str);

        BigDecimal big = new BigDecimal(10);
        System.out.println("변경 전 BigDecimal 값 : " + big);

        // 불변 객체인 BigDecimal 에 값을 더해도 초기에 설정된 내부 값은 변하지 않는다.
        big.add(new BigDecimal(20));
        System.out.println("변경 후 BigDecimal 값 : " + big);
    }
}
