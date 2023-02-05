package com.software.basic.problem.initializer;

/**
 * 1-20 초기화 블록은 생성자와 혼동될 수 있다.
 * - NonStaticInitializer : 비정적 클래스의 생성자는 인스턴스화 될때마다 호출되며
 *                          이것은 거의 사용되지 않아 의도치 않게 동작할 가능성이 높다.
 */
public class NonStaticInitializerExample {
    private int value = 1;

    /*
    * 클래스가 하나의 생성자만 소유하거나, 클래스 내의 각 생성자가 서로 연관성이 없다면 생성자와 중복된 기능인
    * 초기화 블록을 사용하지 않는것이 좋다.
    * 하지만 한 클래스의 여러 개의 성성자가 있고 같은 초기화 절차를 공유한다면 공통적인 절자를 초기화 블록으로
    * 통일하는 것은 유용한 방법일 수 있다.
    * */
    {
        value = 2;
        System.out.println("초기화 블록을 먼저 실행");
    }

    public NonStaticInitializerExample() {
        System.out.println(value);
        System.out.println("생성자는 나중에 실행된다.");
    }
}
