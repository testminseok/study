package com.software.basic.problem.string;

/**
 * 4-2 올바른 문자열 객체 상용법
 *  - StringInstantiation : String 을 인스턴스화 했을 때 수정을 권고한다. (String 은 변경이 불가능한 상수이기 떄문에)
 *  - StringToString : String 인스턴스에 toString 메소드를 호출할때 수정을 권고한다. (불필요한 행위이기 떄문에)
 *  - UselessStringValueOf : 문자열을 추가하기 위해 String.valueOf 를 호출할 경우 수정을 권고한다.
 */
public class WrongStringInstanceExample {
    public static void main(String[] args) {
        // 불필요한 인스턴스화
        String value = new String("test");

        // 불필요한 toString 사용
        String value2 = value.toString();

        // 문자열에 숫자를 결합할 떄 불필요한 valueOf 메소드 사용
        String calValue = "1 + 1 = " + String.valueOf(2);
    }
}
