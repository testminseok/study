package com.software.basic.problem.TEST;

/**
 * 2-1 패키지 명명규칙
 * - 올바른 패키지명
 *  1. 패키지명은 ASCII 코드에 포함된 소문자로 구성한다.
 *  2. 패키지명은 패키지의 기능을 정확히 전달할 수 있는 한 단어의 명사여야 한다.
 *  3. 패키지의 최상위 부분은 소문자의 도메인명이어야 한다.
 *  4. 하위 컴포넌트명은 내부 명명 규칙을 따를 수 있다.
 *  5. 달러 기호($)를 패키지명으로 사용하지 않는다.
 * - PackageCase : 패키지에 대문자가 있는경우 수정을 권고한다.
 * */
public class TestKlass {
    /*
    * package TEST; 대문자로 구성된 패키지명 (x)
    * package wikibook.co.kr; 순서가 잘못된 패키지 도메인명 (x)
    * package kr.co.wilkiBook; 패키지명에 대문자 사용 (x)
    * package kr.co.testUnit; 한 단어 이상의 패키지명 (x)
    * */
}
