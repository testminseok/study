package com.software.basic.problem.debug;

import junit.framework.TestCase;

/**
 * 12-1 JUnit3 에서는 오타가 가장 큰 오류의 주범이다.
 * - JUnitSpelling : setUp 메소드와 tearDown 메소드의 오타가 있을 경우 수정을 권고한다.
 * */
public class IDGeneratorJUnit3Test extends TestCase {

    private static IDGenerator idGenerator;

    /**
     * 테스트 메소드가 실행되기 전 IDGenerator 객체를 초기화한다.
     * 하지만 setUp이 아닌 setup 으로 잘못 등록되었다.
     * */
    protected void setup() throws Exception {
        idGenerator = new IDGenerator(0);
        super.setUp();
    }

    /**
     * JUnit 3의 모든 테스트 메소드는  test 라는 접두사를 포함해야 한다.
     * 모든 테스트 메소드가 실행되기 전 setUp 메소드가 IDGenerator 객체를 초기회 해서
     * 모두 같은 결과가 도출된다.
     * */
    public void testGenerateId() {
        assertEquals(0, idGenerator.newId());
        assertEquals(1, idGenerator.newId());
        assertEquals(2, idGenerator.newId());
    }

    public void testGenerateId2() {
        assertEquals(0, idGenerator.newId());
        assertEquals(1, idGenerator.newId());
        assertEquals(2, idGenerator.newId());
    }

    /**
     * test 가 접두사가 아닌 접미사로 사용되어 테스트 메소드로 사용되지 못함.
     * */
    public void generateId3Test() {
        assertEquals(0, idGenerator.newId());
        assertEquals(1, idGenerator.newId());
        assertEquals(2, idGenerator.newId());
    }
}