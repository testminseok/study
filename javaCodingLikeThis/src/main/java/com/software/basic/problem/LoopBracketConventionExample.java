package com.software.basic.problem;

/**
 * 3-2 for 와 while 문의 괄호 규칙
 * - ControlStatementBraces : 제어문과 반복문을 수행할 때 중괄호를 사용하지 않으면 경고하고 수정을 권고한다.
 * - ForLoopsMustUseBraces : for 문에서 중괄호를 사용하지 않으면 수정을 권고한다. ControlStatementBraces 에 병합됨
 * - WhileLoopMustUseBraces : while 문에서 중괄호를 사용하지 않으면 수정을 권고한다. ControlStatementBraces 에 병합됨
 */
public class LoopBracketConventionExample {
    public static void main(String[] args) {
        int size = 0;
        for (int i = 0; i < 10; i++)
            size++;

        while(size < 20)
            size++;

        System.out.println(size);
    }
}
