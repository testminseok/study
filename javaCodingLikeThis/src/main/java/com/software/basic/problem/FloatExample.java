package com.software.basic.problem;

/**
 * 1-7 for 문에서는 절대 float 를 증감변수로 사용하지 않는다.
 * - DontUseFloatTypeForLoopIndices : for Loop 에서 증감변수가 정수가 아닌 부동소수점으로 사용됐는지 진단하고 수정하길 권고한다.
 * */
public class FloatExample {
    public static void main(String[] args) {
        doubleTest();
        badCode();
        badCode2();
    }

    private static void badCode2() {
        int value = 2_000_000_000;
        int value2 = 2_000_000_050;

        float fValue = 2_000_000_000;
        float fValue2 = 2_000_000_050;

        float dValue = 2_000_000_000;
        float dValue2 = 2_000_000_050;

        // output : int 형 2000000000은 2000000050와다르다
        System.out.println("int 형 " + value + "은 " + value2 + "와" + (value == value2 ? "같다" : "다르다"));
        // output : float 형 2.0E9은 2.0E9와같다
        System.out.println("float 형 " + fValue + "은 " + fValue2 + "와" + (fValue == fValue2 ? "같다" : "다르다"));
        // output : double 형 2.0E9은 2.0E9와같다
        System.out.println("double 형 " + dValue + "은 " + dValue2 + "와" + (dValue == dValue2 ? "같다" : "다르다"));
    }

    /**
     * 잘못된 증감변수 사용
     * */
    private static void badCode() {
        final int START = 2_000_000_000;
        final float TEMP = START;
        int count = 0;
        for (float f = START; f < START + 50; f++) {
            count++;
        }
        System.out.println(count); // output : 0

        /*
        * TEMP 와 TEMP + 50 은 2.0E9 로 같은 값을 가지므로 반복문이 실행과 동시에 종료되어 count 가 0이된다.
        * */
        System.out.println(TEMP);
        System.out.println(TEMP + 50);
    }

    private static void doubleTest() {
        double total = 0;
        total += 4.7;
        total += .4;
        System.out.println(total); // output : 5.1000000000000005
    }
}
