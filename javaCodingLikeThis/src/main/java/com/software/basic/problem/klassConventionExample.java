package com.software.basic.problem;

/**
 * 2-2 클래스 및 인터페이스 명명 규칭
 * - ClassNamingConventions : 정의된 규칙의 정규식에 따라 검사하며, 수정을 권고한다. class naming pattern : [AZ][a-zA-Z0-9]*
 */
public class klassConventionExample {
    /*
    * 잘못된 클래스명의 예
    * public class content // 클래스명은 소문자로 시작해야 한다. (X)
    * public class CONTENT // 클래스명이 모두 대문자다 (X)
    * public class Stringbuilder // 두 번째 단어의 첫 글자가 소문자다(X)
    * public class HtmlUtil // 축약어가 소문자로 구성되어있다 (X) ex) HTMLUtil
    * public class Doc // 다섯 글자 이하의 클래스명 (X)
    * public class Oder_Util // 클래스명에 밑줄(_)은 사용할 수 없다(X)
    * public class $erviceBuilder // 클래서명에 달러 기호($)는 사용할 수 없다 (X)
    *
    * 올바른 클래스명명 규칙
    * 1. 클래스명은 파스칼 표기법을 바탕으로 명명해야 한다.
    * 2. 클래스명에는 명사만 사용할 수 있다.
    * 3. 명사를 사용할 때 너무 긴 경우 축약해서 사용할 수 있지만 의미가 불분명한 너무 짧은 이름은 자제한다.
    * 4. 클래스명 내의 축약단어는 모두 대문자로 표현된다.
    * 5. 5글자 이하의 클래스명은 쓰지 않는다.
    * 6. 클래스명에 밑줄(_)은 사용할 수 없다.
    * 7. 클래스명에 달러 기호($)를 사용하지 않는다.
    * */
}
