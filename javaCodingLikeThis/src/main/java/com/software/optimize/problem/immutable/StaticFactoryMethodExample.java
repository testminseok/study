package com.software.optimize.problem.immutable;

import java.math.BigInteger;

public class StaticFactoryMethodExample {
    public static void main(String[] args)
    {
        /*
        * Boolean 객체의 상태는 true 와 false 만 존재하므로
        * 이 객체는 false 와 true 값을 갖는 신규 객체를 생성하지 않고
        * 미리 등록된 객체를 반환한다.
        * */
//        Boolean bool1 = new Boolean(false); // 새로운 객체를 생성할 필요가 없다.
        Boolean boo1 = Boolean.FALSE;
//        Boolean boo2 = new Boolean(true); // 새로운 객체를 생성할 필요가 없다.
        Boolean boo2 = Boolean.TRUE;

        /*
        * BigInteger 에서 자주 사용되는 0, 1, 10   또한
        * 정적 팩터리 메소드 패턴을 활용해 미리 등록된 값을 반환한다.
        * */
        BigInteger intZero = BigInteger.ZERO;
        BigInteger intOne = BigInteger.ONE;

    }
}
