package com.software.basic.problem;

/**
 * 2-4 메소드 명명규칙
 * - MethodNamingConventions : 메소드명의 명명 규칙은 정규식에 의해 수정을 권고된다. 정규식 :  [az][a-zA-Z0-9]*
 * - ShortMethodName : 메소드명이 너무 짧은경우 가독성이 좋지 않으므로 수정을 권고한다.
 */
public class MethodConventionExample {
    /*
    * 잘못된 메소드명의 예
    * public void ParseInt() // 메소드 첫 글자가 대문자여선 안된다.
    * public void parseint() // 단어의 구분이 없으면 안된다.
    * public void PARSEint() // 대문자로 구성된 단어 X
    * public void parse_int() // 메소드명에 밑줄(_) 사용 X
    * public void par$eInt() // 메소드명에 달러 기호($) 사용 X
    * public void pi() // 메소드명의 의미가 불분명하다
    *
    * 올바른 메소드 명명 방법
    * 1. 메소드명은 카멜 표기법을 바탕으로 지어야 한다.
    * 2. 메소드명에는 동사 또는 동사와 명사의 조합을 사용할 수 있다.
    * 3. 명사를 사용할 때 너무 긴 경우 축약해서 사용할 수 있지만 의미가 불분명한 너무 짧은 이름은 자제한다.
    * 4. 메소드명 내의 축약어는 모두 대문자로 표현한다.
    * 5. 의미가 불분명한 세 글자 이하의 메소드명은 쓰지 않는다.
    * 6. 메소드명에는 밑줄(_)을 사용할 수 없다.
    * 7. 메소드명에는 달러 기호($)를 사용할 수 없다.
    * */
    public void ParseInt() {}

    public void pi() {}
}
