package com.software.basic.problem;

/**
 * 3-1 if 문 괄호 규칙
 * - ControlStatementBraces : 제어문과 반복문을 수행할 때 중괄호를 사용하지 않으면 경고하고 수정을 권고한다.
 */
public class IfBracketConventionExample {
    public static void main(String[] args) {
        int size = 0;
        if (size != 0)
            size ++;

        size++;

        if (size < 2) {
            size++;
        } else
            size++;

        size++;

        System.out.println(size);
    }
}
