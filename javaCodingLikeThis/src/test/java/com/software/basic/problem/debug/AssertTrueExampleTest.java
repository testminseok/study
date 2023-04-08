package com.software.basic.problem.debug;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * 12-3 assertTrue 가 JUnit 의 유일한 단정 메소드가 아니다.
 * - SimplifiableTestAssertion : 보다 구체적인 Assertion 방법을 단순화 할 수 있게 수정을 권고한다.
 *                              [UseAssertEqualsInsteadOfAssertTrue, UseAssertNullInsteadOfAssertTrue
 *                              UseAssertSameInsteadOfAssertTrue, UseAssertTrueInsteadOfAssertEquals]
 *                              룰 을 대체한다.
 * - UseAssertEqualsInsteadOfAssertTrue : 객체의 값이 같은지 비교할 때 assertTrue 를 사용하는지 확인한다.
 * - UseAssertNullInsteadOfAssertTrue : 객체가 null 인지 확인할 때 assertTrue 를 사용하는지 확인한다.
 * - UseAssertSameInsteadOfAssertTrue : 객체의 인스턴스 동일성을 확인할 때 assertTrue 를 사용하는지 확인한다.
 */
public class AssertTrueExampleTest {

    @Test
    public void test() {
        // 의미 없는 테스트
        assertTrue(true);

        // 객체를 assertTrue 는 객체의 값이 같은지 확인하는 데 부적절한다.
        // a가 null 이라면 NullPointerException 이 발생하기 쉽다.
        String a = "test";
        String b = "test";

        assertTrue("a 와 b의 값은 동일해야 한다.", a.equals(b));

        // 객체 자체의 동일성을 확인하는 단정 메소드는 따로 있다.
        String c = "test";
        String d = c;
        assertTrue("c 와 d는 동일한 객체여야 한다.", c == d);

        // 객체가 null 인지 확인하는 단정 메소드도 따로 있으며
        // assertTrue 는 버그를 발생시킬 가능성이 있다.
        String e = null;
        assertTrue("e는 null 이어야 한다.", e == null);
        assertTrue("b 는 비어있어서는 안된다.", !b.isEmpty());
    }
}
