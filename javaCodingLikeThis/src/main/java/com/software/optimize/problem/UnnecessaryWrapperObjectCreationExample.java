package com.software.optimize.problem;

/**
 * 11-3 형변환에 불필요한 메소드 사용
 * - UnnecessaryWrapperObjectCreation : 잘못된 형변환이 일어나는 경우 수정을 권고한다.
 *                                      대부분의 래퍼 클래스는 기본 자료형을 만들기 위해 정적 변환 메소드를 제공한다.
 *                                      이를 사용하면 불필요한 객체 생성을 피할 수 있다.
 *                                      Integer.parseInt(), Long.parseLong(), Double.parseDouble() 등
 *                                      (deprecated PMD 7 에서 는 UnnecessaryBoxing 을 사용한 규칙이 적용)
 * - IntegerInstantiation : Integer 를 생성자를 통해 인스턴스화 할경우 수정을 권고한다.
 *                          Integer 를 인스턴스로 생성하면 Integer.valueOf() 로 피할 수 있는 메모리 할당이 발생한다.
 *                          (자바 9 부터 Integer 의 생성자 deprecated 됨에 따라 해당 룰도 deprecated 됨)
 * - AddEmptyString : 빈 문자열을 사용하여 문자열을 반환하는 경우 수정을 권고한다.
 *                    Integer.toString(456) 를 사용하자
 */
public class UnnecessaryWrapperObjectCreationExample {
    public static void main(String[] args) {
        int i;
        String s = "0";

        // String str = new String(""); // 불필요한 객체 생성
        Integer i2 = new Integer(0);
        // valueOf()는 값을 반환할 때 새로운 인스턴스를 생성하고 반환해 메모리를 낭비
        // Integer 는 int 로 자동 형변환되므로 intValue() 를 사용할 필요가 없다.
        i = Integer.valueOf(s).intValue();

        // Integer 는 int 로 자동 형변환되므로 이런 절차는 무의미하다.
        i2 = Integer.valueOf(i).intValue();

        // valueOf()는 값을 반환할 때 새로운 인스턴스를 생성하고 반환해 메모리를 낭비
        String s2 = Integer.valueOf(i2).toString();

        // 빈 문자열을 추가해 잘못된 방식의 자연수를 문자열로 변환하는 방식은
        // 불필요한 문자열 인스턴스를 생성하므로 비효율적이다.
        String s3 = "" + 2;

        Integer i3 = 3;
        String s4 = "" + i3;
    }
}
