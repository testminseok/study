package com.software.basic.problem;

/**
 * 1-21 Double.NaN 으로 값을 비교하지 않는다.
 * - Double.NaN 과 Float.NaN 을 비교할때는 Double.isNaN(), Float.isNaN() 을 사용해야한다.
 * - NaN 은 정말 숫자가 아니여서 연산자를 이용한 NaN 간의 비교도 불가능하다.
 * - ComparisonWithNaN : Double.NaN, Float.NaN 값과의 비교하는 것을 수정하도록 권과한다.  
 */
public class BadComparisonExample {
    public static void main(String[] args) {
        // 어떠한 이유로 숫자가 아닌 (NaN; Not a Number) 을 할당
        Double errorValue = Double.NaN;
        Float errorFloatValue = Float.NaN;
        
        // 오류를 검증하기 위해 오류 값을 Double.NaN 과 비교
        if (errorValue == Double.NaN) {
            System.out.println("오류 발생");
        } else {
            System.out.println("정상 처리");
        }
        
        /*
        * NaN 과 옳바른 비교
        * */
        if (Float.isNaN(errorFloatValue)) {
            System.out.println("오류 발생");
        } else {
            System.out.println("정상 처리");
        } 
    }
}
