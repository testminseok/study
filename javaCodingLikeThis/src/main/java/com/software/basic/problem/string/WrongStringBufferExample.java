package com.software.basic.problem.string;

/**
 * 4-2 비효율적인 StringBuffer/StringBuilder 사용
 *  - InefficientStringBuffering : StringBuffer 의 생성자 또는 append() 에서 리터털이 아닌것을 연결할 경우 수정을 권고한다.
 *                                  (JVM 에서 중간 버퍼를 만들고 소멸시켜야 하기 때문에)
 */
public class WrongStringBufferExample {
    public static void main(String[] args) {
        /*
        * StringBuffer/StringBuilder 를 사용하는 주된 목적은 문자열을 결합할 때 + 연산자를 사용하지 않음으로서
        * 불필요한 인스턴스의 생성을 방지하는것이다. 하지만 생성자와 append 메소드의 전달인자에 + 연산자를 사용한다면
        * 불필요한 인스턴스가 생성되고 실행 속도 또한 저하되어 StringBuffer/StringBuilder 를 사용하는것이 무의미해진다.
        * */
        StringBuffer buffer = new StringBuffer("String " + System.getProperty("java.io.tmpdir"));
        buffer.append("String" + "Buffer");

        StringBuilder builder = new StringBuilder("String " + System.getProperty("java.io.tmpdir"));
        builder.append("String" + "Builder");

        System.out.println(buffer);
        System.out.println(builder);
    }
}
