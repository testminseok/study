package com.software.basic.problem;

/**
 * 2-7 변수 명명 규칙의 예외 사항
 * - AvoidFieldNameMatchingMethodName : 메소드 이름과 같은 이름의 필드가 있을경우 혼란스러울 수 있으므로 경고하고 수정을 권고한다.
 * - AvoidFieldNameMatchingTypeName : 자료형과 같은 변수명을 갖는 경우 혼란스러울 수 있으므로 경고하고 수정을 권고한다.
 */
public class WrongVariableExample {
    private String wrongVariableExample; // 클래스명과 같은 변수명 (X)
    private String doWhatever; // 메소드와 같은 변수명 (X)
    private String String; // 자료형과 같은 변수명 (X)

    public void doWhatever() {
        System.out.println(String);
    }

    public static void main(String[] args) {
        WrongVariableExample example = new WrongVariableExample();
        example.doWhatever();
    }
}
