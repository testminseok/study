package com.software.basic.problem;

/**
 * 1-9 Boolean 객체의 사용법
 * - BooleanInstantiation : Boolean 객체를 인스터화 하지 않도록 권장하는 Role
 */
public class BooleanExample {
    public static void main(String[] args) {
        badCode();
        goodCode();
    }

    /**
     * Boolean 객체는 valueOf 메소드 또는 Boolean.TRUE 상수를 사용한다.
     * JDK 9 부터는 new Boolean 은 더이상 사용되지 않는다.
     * */
    private static void goodCode() {
        Boolean boolTrueByValueOf = Boolean.valueOf(true);
        Boolean boolTrueByStaticField = Boolean.valueOf(true);
        Boolean boolFalseByValueOf = Boolean.valueOf(false);
        Boolean boolFalseByStaticField = Boolean.FALSE;

        System.out.println(boolTrueByValueOf);
        System.out.println(boolTrueByStaticField);
        System.out.println(boolFalseByValueOf);
        System.out.println(boolFalseByStaticField);
    }

    /**
     * 불필요한 Boolean 객체를 생성항 예
     * */
    private static void badCode() {
        Boolean bool = new Boolean(true);

        System.out.println(bool);
    }
}
