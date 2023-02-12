package com.software.basic.problem;

/**
 * 2-6 변수 명명 규칙
 * - VariableNamingConventions : 변수의 대소문자와 변수가 밑줄(_)을 포함할때 경고하고 수정을 권고한다.
 * - FieldNamingConventions : Role 에서 정의된 변수 명명 규칙에 대한 정규식과 일치하는지 확인한다.
 *      - public 한 상수 : [A-Z][A-Z_0-9]*
 *      - non-public static final : [A-Z][A-Z_0-9]*
 *      - enum 으로 정의된 상수 : [A-Z][A-Z_0-9]*
 *      - final field : [a-z][a-zA-Z0-9]*
 *      - static field : [a-z][a-zA-Z0-9]*
 *      - default field : [a-z][a-zA-Z0-9]*
 * - AvoidDollarSigns : 변수/메소드/클래스/인터페이스 이름에 달러 기호($)를 사용해선 안된다.
 * - LongVariable : 너무 긴 변수명은 코드를 따라가기 어렵게 만들 수 있다. (가독성이 좋지 않다)
 * - ShortVariable : 매우짧은 변수명은 코드를 읽는사람에게 도움이 되지 못한다. (가독성이 좋지 않다)
 */
public class VariableConventionExample {
    /*
    * 올바른 변수명 명명 방법
    * 1. 변수명은 카멜 표기법을 바탕으로 지어야한다.
    * 2. 변수명 내의 축약어는 모두 대문자로 표현한다.
    * 3. 반복문의 증감변수 등 임시 변수가 아니면 의미가 불분명한 세 글자 이하의 변수명은 쓰지 않는다.
    * 4. 너무 긴 변수명은 사용하지 않는다.
    * 5. 변수명에 밑줄(_)를 사용할 수 없다.
    * 6. 변수명에 달러 기호($)를 사용할 수 없다.
    * 7. 공통 사전을 만들어 변수명에 사용되는 공통적인 단어를 정의한다.
    * */
    String Value; // 대문자로 시작하는 변수명 (X)
    String VALUE; // 대문자로 된 변수명 (X)
    String groupname; // 단어의 구분이 부정확한 변수명 (X)
    String Pneumonoultramicroscopicsilicovolcanoconiosis; // 너무 긴 변수명 (X)
    String a; // 무의미한 한 글자로 된 너무 짧은 변수명 (X)
    int temp; // 무의미한 임시 변수명 (X)
    String numValue; // 의미가 부정확한 변수명 (X)
    boolean statu$; // 달러 기호를 사용한 변수명 (X)
    boolean group_name; // 밑줄을 사용한 변수명 (X)
}
