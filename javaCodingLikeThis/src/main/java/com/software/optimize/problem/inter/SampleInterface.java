package com.software.optimize.problem.inter;

/**
 * 11-6 인터페이스는 기능의 명세서 역활만을 수행한다.
 *  - 추상클래스와 인터페이스를 구분하여 사용하자. 인터페이스는 규격이며 추상클래스는 기능을 구현하기 위한 설계도와 같다.
 * */
public interface SampleInterface {
    /*
    * 인터페이스는 객체의 소통 방식을 정의하는 규약이므로
    * 기본적으로 인터페이스 내부의 모든 요소는 public 으로 공개돼 있다.
    * 따라서 public 키워드를 따로 붙일 필요가 없으며,
    * private 과 protected 를 사용할 수 없다.
    * */
    int value = 0;
    String str = "test";

    void printValue();

    void printStr();
}
