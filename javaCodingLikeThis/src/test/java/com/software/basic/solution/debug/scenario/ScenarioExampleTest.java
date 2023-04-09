package com.software.basic.solution.debug.scenario;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 12-3 너무 긴 테스트 시나리오는 단위 테스트의 목적을 불분명하게 만든다.
 * - JUnitTestContainsTooManyAsserts : 단위 테스트에 너무 많은 assertion 이 포함되어 있는경우 수정을 권고한다.
 *                                     테스트 시나리오를 여러 개의 더 짧은 테스트 시나리오로 나누어 테스트를 수행한다.
 * */
public class ScenarioExampleTest {
    private DocumentVO document;
    private static DocumentController controller;

    @BeforeClass
    public static void setUpBeforeClass() {
        controller = new DocumentController();
    }

    @Before
    public void setUp() {
        document = new DocumentVO();
        document.setDocId("DOC001");
        document.setTitle("제목");
        document.setBody("내용");
        document.setAuthor("김나박이");
    }

    @Test
    @DisplayName("문서가 null 인 경우")
    public void emptyDocument() {
        assertFalse("문서 생성 실패 : 문서는 null 일 수 없다.", controller.create(null));
    }

    @Test
    @DisplayName("문서 ID가 DOC 으로 시작해야한다")
    public void documentIdStartWithDOC() {
        document.setDocId("IMG001");
        assertFalse("문서 생성 실패 : docId의 접두사는 DOC 이어야 한다.", controller.create(document));
    }

    @Test
    @DisplayName("문서 제목은 null 일 수 없다")
    public void documentTitleCantNotBeNull() {
        document.setTitle(null);
        assertFalse("문서 생성 실패 : 문서 제목은 null 일 수 없다.", controller.create(document));
    }

    @Test
    @DisplayName("문서 제목은 최대 20자 이다")
    public void documentTitleLength20() {
        document.setTitle("0123456789012345678901234567890");
        assertFalse("문서 생성 실패 : 문서 제목의 길이는 최대 20자 이다.", controller.create(document));
    }

    @Test
    @DisplayName("문서 정상 생성")
    public void documentCreateSuccess() {
        assertTrue("문서 생성 실패 : 문서 생성 중 오류 발생", controller.create(document));
    }
}
