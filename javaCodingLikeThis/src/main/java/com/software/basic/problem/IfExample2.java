package com.software.basic.problem;

/**
 * 1-2 아무것도 하지않는 if 문은 제거한다.
 * - UnconditionalIfStatement : 코드 상의 잘못된 조건문을 분석하고 수정을 권고하다록 만들어졌다.
 * */
public class IfExample2 {
    public static void main(String[] args) {
        String param = args.length == 0 ? "" : args[0];
        boolean isAdmin = "admin".equals(param);

        /*
         * 원래는 관리자임을 확인하고 진행해야 하는 코드지만,
         * 개발자가 임의로 프로세스 진행을 확인하기 위해 임의로 수정한 조건문
         * */
//        if (isAdmin) {
        if (true) {
            // code
        }
    }
}
