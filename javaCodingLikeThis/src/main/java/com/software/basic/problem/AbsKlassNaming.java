package com.software.basic.problem;

/**
 * 2-3 추상클래스 명명규칙
 * - 추상클래스 명명규칙은 기본적으로 클래스 명명규칙과 동일하다.
 * - AbstractNaming : 추상클래스의 클래스이름은 Abstract* 으로 지정해야한다.
 */
public abstract class AbsKlassNaming {
    /*
     * 잘못된 추상 클래스명의 예
     * public abstract class Content // 추상 클래스의 이름에는 Abstract 를 접두사로 붙인다.
     * public class AbstractContent // 일반 클래스에는 Abstract 를 접두사로 사용하지 않는다.
     *
     * 올바른 클래스명명 규칙
     * 1. 클래스명은 파스칼 표기법을 바탕으로 명명해야 한다.
     * 2. 클래스명에는 명사만 사용할 수 있다.
     * 3. 명사를 사용할 때 너무 긴 경우 축약해서 사용할 수 있지만 의미가 불분명한 너무 짧은 이름은 자제한다.
     * 4. 클래스명 내의 축약단어는 모두 대문자로 표현된다.
     * 5. 5글자 이하의 클래스명은 쓰지 않는다.
     * 6. 클래스명에 밑줄(_)은 사용할 수 없다.
     * 7. 클래스명에 달러 기호($)를 사용하지 않는다
     * 8. 추상 클래스명에는 접두사로 Abstract 를 포합한다.
     * */
}
