package com.software.optimize.problem.unused;

/**
 * 11-7 사용하지 않는 소스코드는 삭제하자
 * - UnusedLocalVariable : 사용하지 않는 지역 변수가 있는 경우 수정을 권고한다.
 * - UnusedPrivateField : 사용하지 않는 private 필드가 선언 또는 값이 할당되었지만 사용하지 않는경우 수정을 권고한다.
 * - UnusedPrivateMethod : 사용하지 않는 private 메소드가 선언되었지만 사용하지 않는 경우 수정을 권고한다.
 * - UnusedFormalParameter : 사용하지 않는 매개변수가 있는 경우 수정을 권고한다.
 */
public class UnusedExample {
    // 사용되지 않는 private 클래스 멤버 변수
    private String str = "test";

    // 사용되지 않는 private 클래스 멤버 메소드
    private void unusedMethod() {
        System.out.println("unused method");
    }

    public void sampleMethod() {
        // 사용되지 않는 지역 변수
        String temp = "temp";
        System.out.println("temp 는 사용되지 않았다");
    }

    /**
     * @param usedValue 사용되는 매개변수
     * @param unusedValue 사용되지 않는 매개변수
     */
    public void sampleMethod(int usedValue, int unusedValue) {
        System.out.println("usedValue = " + usedValue);
    }
}
