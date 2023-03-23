package com.software.design.problem.staticclass;

import java.text.DecimalFormat;

/**
 * 스레드 동기화를 이용한 싱글톤 클래스 구현 방법
 */
public class SingletonClassExample2 {
    private volatile static SingletonClassExample2 instance;

    private SingletonClassExample2() {
    }

    public static SingletonClassExample2 getInstance() {
        synchronized (SingletonClassExample2.class) {
            if (instance == null) {
                instance = new SingletonClassExample2();
            }
        }

        return instance;
    }

    public boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public String changeMoney(String str) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(Integer.parseInt(str));
    }
}
