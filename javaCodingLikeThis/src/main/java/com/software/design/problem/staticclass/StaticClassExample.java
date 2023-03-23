package com.software.design.problem.staticclass;

import java.text.DecimalFormat;

/**
 * 정적 클래스 테스트를 위한 클래스
 * 모든 메소드는 public static 으로 정의 되어 있다.
 */
public class StaticClassExample {

    /**
     * 빈 문자열인지 확인하는 정적 메소드
     * @param value
     * @return
     * */
    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    /**
     * 문자열을 자릿수가 있는 숫자로 변경하는 메소드
     * @param str
     * @return
     * */
    public static String changeMoney(String str) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(Integer.parseInt(str));
    }
}

