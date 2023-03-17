package com.software.design.problem.inner;

/**
 * 9-6 캡슐화를 위한 내부 클래스는 오히려 결합도와 응집도를 모두 저해한다.
 * - AccessorClassGeneration : 내부 클래스를 생성하는 것을 경고하고 수정을 권고한다.
 *                             내부 클래스를 구현하면 의미 있는 패키지 범위와 클래스를 식별하기 어렵다.
 */
public class OuterClass {
    public OuterClass() {
        InnerClass innerClass = new InnerClass();
        System.out.println("OuterClass Constructor Call.");
    }

    public class InnerClass {
        /*
         * 내부 클래스의 생성자가 private 키워드를 통해 접근이 제한되어
         * OuterClass 만 생성자를 호출할 수 잇다.
         * */
        private InnerClass() {
            System.out.println("InnerClass Constructor Call.");
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
    }
}
