package com.software.design.problem.staticclass;

import java.text.DecimalFormat;

/**
 * Singleton 클래스를 내부 클래스를 이용해 구현하는 방식
 */
public class SingletonClassExample {

    /**
     * Singleton 클래스는 하나의 객체만 유지해야 하므로
     * 외부에서 직접적인 클래스 생성을 막기 위해
     * 생성자에 private 을 지정해 접근을 제한한다.
     * */
    private SingletonClassExample() {
    }

    /**
     * Singleton 클래스의 단일 인스턴스를 관리할 내부 클래스를 만들어
     * 객체의 유일성을 유지한다.
     * */
    private static class SingletonClassExampleBuilder {
        static final SingletonClassExample instance = new SingletonClassExample();
    }

    /**
     * 객체의 유일한 인스턴스를 내부 클래스의 static 필드로부터 호출해서 전달한다.
     * */
    public static SingletonClassExample getInstance() {
        return SingletonClassExampleBuilder.instance;
    }

    public boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public String changeMoney(String str) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(Integer.parseInt(str));
    }

}
