package com.software.basic.problem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 7-1 비어있는 예외 처리는 치명적인 결함을 무시한다.
 * - EmptyCatchBlock : 예외가 포착되었지만 아무런 예외 처리 작업을 하지 않는경우 수정을 권고한다.
 */
public class EmptyExceptionExample {

    public static Logger log = Logger.getLogger(EmptyExceptionExample.class.getName());

    public static void main(String[] args) {
        String str = null;

        try {
            System.out.println(str.substring(0, 2));
        } catch (Exception e) {
            log.log(Level.WARNING, e.getMessage());
        }
        
        System.out.println(str.substring(0, 2)); // 주석 처리시 정상 종료
        System.out.println("프로그램 종료");
    }
}
