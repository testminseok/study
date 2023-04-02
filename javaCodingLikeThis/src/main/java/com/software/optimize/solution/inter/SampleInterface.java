package com.software.optimize.solution.inter;

public interface SampleInterface {
    /*
    * 인터페이스는 객체의 소통 방식을 정의하는 규약이므로
    * 기본적으로 인터페이스 내부의 모든 요소는 public 으로 공개돼 있다.
    * 따라서 public 키워드를 따로 붙일 필요가 없으며,
    * private 과 protected 를 사용할 수 없다.
    * */

    void printValue();

    void printStr();
}
