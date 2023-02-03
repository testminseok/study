package com.software.basic.problem;

/**
 * 1-17 finally 절에서는 return 을 사용하지 않는다.
 * - ReturnFromFinallyBlock : finally 에서 return 을 사용하는 문제점을 진단하고 수정을 권고한다.
 */
public class FinallySample {

    public static void main(String[] args) {
        FinallySample sample = new FinallySample();
        System.out.println(sample.badCode()); // OK
    }

    /**
     * throw new Exception("") 으로 예외를 발생시키고 catch 에서도 예외를 그대로 발생시켰지만
     * 결과는 Exception 이 발생하지 않은것처럼 finally 에서 리턴한 값이 반환된다.
     * 이처럼 개발자가 의도하지 않은 상황이 발생할 수 있으므로 finally 에서는 return 을 하지 않는다.
     * */
    public String badCode() {
        try {
            throw new Exception("");
        } catch (Exception e) {
            throw e;
        } finally {
            return "OK";
        }
    }

    /**
     * 불필요한 finally 절의 return 문을 삭제한다.
     * */
    public String goodCode() throws Exception {
        try {
            throw new Exception("");
        } catch (Exception e) {
            throw e;
        }
    }
}
