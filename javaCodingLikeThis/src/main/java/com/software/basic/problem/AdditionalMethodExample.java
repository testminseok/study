package com.software.basic.problem;

/**
 * 2-5 사용할 수 없는 메소드명
 * - MethodWithSameNameAsEnclosingClass : 생성자가 아닌 메소드는 클래스명과 같은 이름을 가져선 안된다.
 * - SuspiciousEqualsMethodName : equals 와 비슷한 메소드명을 가져선 안된다. Object.equals 를 재정의 하려는 의도로 해석할 수 있고
 *                                Object.equals 를 오버로딩 하게 되므로 상속받을때 오류가 발생하기 쉽고 유지보수 하기 어렵다.
 * - AvoidDollarSigns : 변수/메소드/클래스/인터페이스 이름에 달러 기호($)를 사용해선 안된다.
 * - BooleanGetMethodName : Boolean 값을 반환하는 메소드는 술어로 메소드 명을 접두사로 사용한다.
 *                          ex) isReady(), hasValues(), canCommit(), willFail() 등
 */
public class AdditionalMethodExample {
    /*
    * 사용할 수 없는 메소드명
    * public AdditionalMethodExample() {} // 클래스의 생성자
    * public void AdditionalMethodExample() {} // 일반 메소드와 클래스명이 같음 (X)
    * public void hashCode() {} // 기본 메소드를 일반 메소드명으로 사용 (X)
    * public void equals() {} // 기본 메소드를 일반 메소드명으로 사용 (X)
    * public boolean getReady() {} // Boolean 값을 반환하는 메소드에 get 을 접두사로 사용 (X)
    * public void $tart() {} // 메소드명에 달러 기호($) 사용 (X)
    *
    * 올바른 메소드 명명
    * 1. 오직 생성자만이 클래스와 같은 이름을 사용할 수 있다.
    * 2. hasCode 와 equals 는 객체 비교를 위한 기본 메소드로서 일반 메소드명으로 사용할 수 없다.
    * 3. boolean 값을 반환하는 메소드의 접두사는 술어를 사용한다. ex) is, has, can, will 등
    * 4. 달러 기호($) 를 절대 사용하지 않는다.
    * */

//    public AdditionalMethodExample() {} // 클래스의 생성자
//    public void AdditionalMethodExample() {} // 일반 메소드와 클래스명이 같음 (X)
//    public void hashCode() {} // 기본 메소드를 일반 메소드명으로 사용 (X)
//    public void equals() {} // 기본 메소드를 일반 메소드명으로 사용 (X)
//    public boolean getReady() {} // Boolean 값을 반환하는 메소드에 get 을 접두사로 사용 (X)
//    public void $tart() {} // 메소드명에 달러 기호($) 사용 (X)
}
