package com.software.design.solution.call;

/**
 * 9-5 생성자에서는 재정의 가능한 메소드를 호출해서는 안된다.
 * - ConstructorCallsOverridableMethod : 생성자에서 재정의될 수 있는 메소드를 호출할때 수정을 권고한다.
 *                                       - 하위 클래스에서 메소드를 재정의 하여 인스턴스 변수를 사용할 경우 NPE 가 발생할 수 있다.
 */
abstract  class ParentClass {
    public ParentClass() {
        /*
        * toString 은 자식 클래스에서 재정의할 수 없으므로 재정의 가능한 메소드 호출하는 문제를
        * 원천적으로 차단한다.
        * */
        toString();

        /*
        * print 는 자식 클래스로 구현 권한을 온전히 위임했을므로 부모 자식 클래스 간의 재정의 충돌이 발생하지 않는다.
        * */
        print();
    }

    protected abstract void print();

    public final String toString() {
        return "아이엠 유어 팥더";
    }
}
