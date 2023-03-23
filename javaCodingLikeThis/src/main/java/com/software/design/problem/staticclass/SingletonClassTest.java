package com.software.design.problem.staticclass;

/**
 * 9-8 static 메소드로만 이뤄진 클래스는 싱글톤 패턴으로 변환한다.-
 * */
public class SingletonClassTest {

    /*
    * 싱글톤 또한 많은 문제점을 가지고 있는데 여전히 싱글톤 클래스 내부에 static 필드가 존재하며
    * private 이 지정된 생성자로 인해 상속과 다형성이 제한된다는 문제접이 있다.
    * 그 밖에도
    * 1. private 으로 접근이 제한된 내부의 static 필드가 존재해서 싱글톤 클래스의 상속은 불가능하며 이를 위해 생성자를
    *    변경하는 등의 추가적인 코드 변경이 필요하다.
    * 2. 싱글톤 클래스는 테스트하기 어렵다. 싱글톤 클래스는 getInstance 메소드와 같이 싱글톤을 만드는 방식이 제한돼 있어서
    *    테스트를 위한 모의 객체를 만들기 어렵고 이를 위해서도 별도의 코드 변경이 필요하다.
    * 3. 실긍톤 클래스는 개발 편의성을 위해 정적 클래스로 변경되어 사용될 가능성이 매우 높다.
    * 4. JVM 구성에 따라 싱글톤 클래스는 하나 이상의 인스턴스로 만들어질 수 있다. 또한 분산환경에서 구동되는
    *    프로그램 또한 각 JVM 에 동립된 객체가 생길 수 있다.
    * */

    public static void main(String[] args) {
        /**
         * 싱글톤 클래스를 사용할 때는 getInstance() 메소드를 이용해 유일 객체를 호출한다.
         * 싱글톤 클새느는 생성자가 private 으로 지정돼 있어 외부에서
         * 새로운 객체를 생성할 수 없다.
         * */
        System.out.println(SingletonClassExample.getInstance().isEmpty(""));
        System.out.println(SingletonClassExample.getInstance().changeMoney("1234"));
    }
}
