package com.software.design.problem.call;

public class ChildrenClass extends ParentClass {
    private String name;

    public ChildrenClass(String name) {
        /*
        * 부모 클래스의 생성자를 호출할 때
        * toString 은 이미 자식 클래스의 toString 으로 재정의된 상태다.
        * 그러므로 name 은 아직 null 인 상태이므로 .toUpperCase() 를 호출하면 NPE 가 발생한다.
        * */
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }
}
