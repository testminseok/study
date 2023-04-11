package com.software.debug.solution;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * 13-2 GOTO 와 같은 예외 처리 구조는 예외 처리를 더욱 복잡하게 만든다.
 * - ExceptionAsFlowControl : 예외를 흐름 제어로 사용하는 경우 수정을 권고한다.
 */
public class GotoExample {
    public static void main(String[] args) {
        try {
            // code..
            System.out.println("원래 오류 발생");
            throw new MalformedURLException();
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException 처리");
        } catch (IOException e) {
            System.out.println("IOException 처리");
        }
    }
}
