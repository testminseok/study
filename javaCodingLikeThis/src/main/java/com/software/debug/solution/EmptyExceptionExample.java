package com.software.debug.solution;

import java.util.logging.Logger;

public class EmptyExceptionExample {
    public static Logger logger = Logger.getLogger(EmptyExceptionExample.class.getName());

    public void errorMethod() {
        try {
            // 오류가 발생할 가능성이 있는 코드 ...
        } catch (Exception e) {
            logger.throwing("EmptyExceptionExample", "errorMethod", e);
        }
    }
}
