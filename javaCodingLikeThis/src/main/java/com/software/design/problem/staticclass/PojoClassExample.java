package com.software.design.problem.staticclass;

import java.text.DecimalFormat;

/**
 * POJO(Plain Old Java Object)는 특정 환경 또는 특정 규약에 종속되지 않은
 * 일반적인 자바 객체를 의미한다.
 *
 * 이 클래스는 일반적인 클래스의 예다.
 * */
public class PojoClassExample {
    public boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public String changeMoney(String str) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(Integer.parseInt(str));
    }
}
