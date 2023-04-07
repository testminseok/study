package com.software.basic.problem.debug.equals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

/**
 * 12-2 단정 메소드의 실패 메세지는 디버깅에 효율적이다.
 * - JUnitAssertionsShouldIncludeMessage : 단정 메소드의 실패 메세지가 없을 경우 수정을 권고한다.
 */
public class AssertEqualsCodeExample {

    private static CodeGenerator codeGenerator;

    @Before
    public void setUp() throws Exception {
        codeGenerator = new CodeGenerator();
    }

    @Test
    @DisplayName("문자를 코드로 변환하는 기능이 정상적으로 작동하는지")
    public void testToCode() {
        // 정상적으로 예상한 값과 실제 값이 같다면 테스트가 통과한다.
        assertEquals("CODE001", codeGenerator.toCode("입금"));
        assertEquals("CODE002", codeGenerator.toCode("출금"));
        assertEquals("CODE003", codeGenerator.toCode("조회"));

        // 예상한 값과 실제 값이 다르면 오류가 발생해 소스코드의 문제점을 진단할 수 있다.
        assertEquals("CODE003", codeGenerator.toCode("이체"));
    }
}
