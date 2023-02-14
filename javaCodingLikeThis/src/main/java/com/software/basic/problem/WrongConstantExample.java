package com.software.basic.problem;

/**
 * 2-8 상수 명명 규칙
 * - FieldNamingConventions : 정규식의 의해 검사를 하며 상수의 경우 [AZ][A-Z_0-9]* 와 같은 정규식을 사용한다
 * -
 */
public class WrongConstantExample {
    /*
    * 올바른 상수 명명 방법
    * 1. 상수명은 모두 대문자와 밑줄(_)로 구성한다.
    * 2. 상수명에는 달러 기호($) 등의 특수 문자를 사용할 수 없다.
    * 3. 상수명 또한, 공통 사전을 만들어 상수명의 일관성을 유지해야한다.
    * */
    private static final String name = "name"; // 상수명에 소문자 사용 (X)
    private static final String USERnAme = "name"; // 잘못된 단어 같 구분 (X)
    private static final String U$ER_NAME = "name"; // 달러 기호($) 사용 (X)
    private String USER_NAME = "name"; // 클래스 멤버 변수에 상수명을 사용 (X)
}
