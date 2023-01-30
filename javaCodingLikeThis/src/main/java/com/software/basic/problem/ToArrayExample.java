package com.software.basic.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1-14 올바른 toArray 메소드 사용법
 * - OptimizableToArrayCall : toArray 메소드를 사용할때 매개변수로 크기가 0인 배열을 지정해야한다.
 *                            이를 통해 JVM 은 메모리 할당 및 복사를 최적화 할 수 있다. (6.0 이후로 반대로 바뀜)
 * - ClassCastExceptionWithToArray : toArray 메소드를 사용할때 매개변수와 동일한 클래스의 배열을 제공해야한다.
 *                                   그렇지 않으면 ClassCastException 이 발생한다.
 */
public class ToArrayExample {

    private static final List SAMPLE_LIST = List.of("aaa", "bbb", "ccc");
    public static void main(String[] args) {
        badCode(SAMPLE_LIST);
        goodCode(SAMPLE_LIST);

    }

    private static void goodCode(List<String> list) {
        /*
        * toArray 메소드는 대상이 되는 배열의 자료형과 배열의 길이만 정확하게 전달하면
        * 자동으로 변환된 결과를 반환한다.
        * */
        String[] array = list.toArray(new String[list.size()]);
        for (String value : array) {
            System.out.println(value);
        }
    }

    private static void badCode(List<String> list) {

        String[] array = new String[list.size()];

        // 1. 느리고 불필요한 코드가 존재한다.
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        // 2. new String[0]의 크기가 0이라서 내부적으로 불필요한 객체를 생성해야한다.
        String[] array2 = list.toArray(new String[0]);

        // 3. java.lang.ClassCastException 예외가 발생한다.
//        String[] array3 = (String[]) list.toArray();
    }
}
