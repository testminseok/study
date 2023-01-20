package com.software.basic.problem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IfExample2Test {

    private static String param;

    /**
     * @BeforeEach 는 Junit5 에서 @Before 와 같은 Annotation 이며
     * if (true) 로 무조건 조건을 통과하도록 수정하는 것이 아닌
     * 아래의 메소드와 같이 원본 코드를 수정할 필요 없이 필요한 모의 상황을
     * 만들어서 테스트할 수 있다.
     * */
    @BeforeEach
    public void setParam() {
        param = "admin";
    }

    @Test
    public void test() {
        boolean isAdmin = "admin".equals(param);

        /*
         * 원래는 관리자임을 확인하고 진행해야 하는 코드지만,
         * 개발자가 임의로 프로세스 진행을 확인하기 위해 임의로 수정한 조건문
         * */
        if (isAdmin) {
            System.out.println("관리자 입니다만 ?");

            // code...
        }
    }
}