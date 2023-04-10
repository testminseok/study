package com.software.debug.problem;

import java.io.*;

/**
 * 13-1 예외 정보를 무시하는 것은 소프트웨어 유지보수를 포기하는 것과 같다
 * - EmptyCatchBlock : 예외가 발생했지만 아무 작업도 수행하지 않는 catch 블록이 있으면 수정을 권고한다.
 * - AvoidThrowingRawExceptionTypes : 예외 객체를 최상위 객체로 처리하는 경우 수정을 권고한다.
 * - SignatureDeclareThrowsException : 매소드/생성자 시그니처에 정확한 오류 정보가 아닌 Exception 을 선언하면 수정을 권고한다.
 * - AvoidCatchingThrowable : Throwable 을 catch 하는경우 수정을 권고한다.
 * - AvoidInstanceofChecksInCatchClause : catch 절에서 instanceof 를 사용하는 경우 수정을 권고한다. (포착된 예외 유형은 각 catch 절에서 처리해야 한다.)
 */
public class BadExceptionExample {
    /**
     * 발생한 모든 오류를 catch 절로 받아서 무시하는 방식
     * 이 메소드에서 어떠한 오류가 발생했는지는 아무도 알 수 없다.
     * */
    public void errorMethod() {
        try {
            // 오류가 발생할 가능성이 있는 코드 ...
        } catch (Exception e) {
            // 오류가 발생했을 때 아무런 처리도 하지 않는다.
        }
    }

    /**
     * 발생된 모든 예외를 호출한 메소드나 객체로 전달하고 무시함
     * 정확한 오류 발생 위치와 정보를 알 수 없다.
     * */
    public void errorMethod2(String path, String str) throws Exception {
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(str);
        writer.close();
    }

    /**
     * 개발자가 선택한 오류 이외의 모든 오류가 무시된다.
     * */
    public void errorMethod3() {
        try {
            // 오류가 발생할 가능성이 있는 코드 ...Throwable 오류를 잡는 것은
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                // 오류처리
            } else if (e instanceof IOException) {
                // 오류처리
            }
        }
    }
    
    /**
     * Exception 와 같은 상위 클래스로 Error 를 발생시키는 대신 서브클래스로 예외처리
     * */
    public void errorMethod4() throws Exception {
        throw new Exception();
    }

    /**
     * catch 절에서 예외를 Throwable 로 잡아서 처리하는 경우 그 범위가 매우 넓기 때문에 권장하지 않는다.
     * */
    public void errorMethod5() {
        try {
            // 오류가 발생할 가능성이 있는 코드 ...
        } catch (Throwable e) {
            // 오류가 발생했을 때 아무런 처리도 하지 않는다.
        }
    }
}
