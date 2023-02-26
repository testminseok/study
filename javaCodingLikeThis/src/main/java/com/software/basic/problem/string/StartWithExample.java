package com.software.basic.problem.string;

import java.util.function.Predicate;

/**
 * 4-9 문자열의 시작 문자를 검사할 때는 startsWith 가 아닌 chartAt 을 활용하자.
 * - SimplifyStartsWith : 한 글자를 접두사로 찾을 경우 수정을 권고한다.
 *                        그러나 가독성을 희생한다. 또한 IndexOutOfBoundException 을 발생시키지 않기 위해 문자열이
 *                        비어있는지 확인작업을 먼저 해야한다.
 *                        또한 가독성을 해치는것에 비해 최적화가 미비하기애 Deprecated 되었다.
 */
public class StartWithExample {
    public static void main(String[] args) {
        StartWithExample example = new StartWithExample();
        example.doStartsWith();
        example.doIndexOf();
        example.doCharAt();
    }

    /*
    * 찾고자 하는 접두사가 한글자로만 구성되어 있다면 charAt(0) 을 활용하는 편이 더욱더 빠른 방법이다.
    * IndexOutOfBoundException 을 발생시키지 않기 위해 문자열이 비어있는지 확인작업을 먼저 해야한다.
    * */
    private void doCharAt() {
        timeLog(str -> !str.isEmpty() && str.charAt(0) == 'C');
    }

    /*
    * 찾고자 하는 접두사를 찾을때 indexOf 보다는 startsWith 가 더욱 빠르고 불필요한 인스턴스가 생성되는것을 방지할 수 있다.
    * */
    private void doIndexOf() {
        timeLog(str -> str.indexOf("CDP") == 0);
    }

    private void doStartsWith() {
        timeLog(str -> str.startsWith("C"));
    }

    private void timeLog(Predicate<String> predicate) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            if (predicate.test("CDP00001")) {
//                System.out.println("메세지출력");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("실행시간 : " + (endTime - startTime)/1000.0f);
    }
}
