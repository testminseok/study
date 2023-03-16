package com.software.design.problem.call;

/**
 * 9-5 생성자에서는 재정의 가능한 메소드를 호출해서는 안된다.
 * - ConstructorCallsOverridableMethod : 생성자에서 재정의될 수 있는 메소드를 호출할때 수정을 권고한다.
 *                                       - 하위 클래스에서 메소드를 재정의 하여 인스턴스 변수를 사용할 경우 NPE 가 발생할 수 있다.
 */
public class ParentClass {
    public ParentClass() {
        // toString 을 자식 클래스에서 재정의했을 경우
        // NPE 이 발생할 가능성이 있다.
        toString();
    }

    public String toString() {
        return "아이엠 유어 팥더";
    }
}
