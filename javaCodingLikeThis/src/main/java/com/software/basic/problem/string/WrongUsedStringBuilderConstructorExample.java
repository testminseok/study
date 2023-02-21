package com.software.basic.problem.string;

/**
 * 4-5 올바른 StingBuilder/StringBuffer 생성자 사용
 *  - StringBufferInstantiationWithChar : StringBuffer 의 생성자에 char 값은 int 로 변환되므로 혼란을 줄수 있어 수정을 권고한다.
 * */
public class WrongUsedStringBuilderConstructorExample {
    public static void main(String[] args) {
        /*
        * StringBuilder 의 최적화를 위해 StringBuilder 의 길이를 설정할 수 있지만
        * 오히려 StringBuilder 의 성능이 저하된다.
        *
        * 해결법 : 길이는 필요한 만큼 충분히 설정하는 것이 좋다.
        * */
        StringBuilder builder = new StringBuilder(10);
        StringBuffer buffer = new StringBuffer(10);

        /*
        * 이렇게 원래 예상한 StringBuilder/StringBuffer 의 길이보다 긴 문자열이 입력되면
        * 내부 문자열 길이를 변경하는 작업이 빈번하게 발생한다.
        * */
        String tempStr = "0123456789";
        for (int i = 0; i < 10; i++) {
            builder.append(tempStr);
            buffer.append(tempStr);
        }

        /*
        * StringBuilder 의 값을 문자 a로 생성해 등록하려는 목적으로
        * char 형의 문자를 입력하면 StringBuilder 는 이 문자를 ASCII 코드 값으로 변경해
        * StringBuilder 의 길이로 설정한다. 즉, a 는 ASCII 코드 값으로 97 이므로
        * StringBuilder builder2 = new StringBuilder(97); 과 동일하다.
        *
        * 해결법 : 문자(char)가 아닌 문자열(String) 으로 초기화 해야한다.
        * */
        StringBuilder builder2 = new StringBuilder('a');
        StringBuffer buffer2 = new StringBuffer('a');

    }
}
