package com.software.basic.problem;

/**
 * 1-5 잘못된 위치의 null 비교
 * - MisplacedNullCheck : 잘못된 위치의 null 값 비교 문제를 자동으로 분석하고 방지할 수 있는 룰
 */
public class NullCheckExample2 {
    public static void main(String[] args) {
        /*
        * 인자가 null 이면 두 메소드 모두 NPE 가 발생한다.
        * */
        System.out.println(isEmpty("test"));
        System.out.println(isEmpty(null));

        System.out.println(isEmpty2("test"));
        System.out.println(isEmpty2(null));
    }

    private static boolean isEmpty2(String value) {

        /*
        * value 가 null 이면 NPE 가 발생해야 하며
        * equals 는 작동하지 않아야 한다.
        * 그러므로 value == null 과 같은 체크는 잘못된 null 검사다.
        * */
        if (value.equals("") || value == null) {
            return true;
        }

        return false;
    }

    private static boolean isEmpty(String value) {
        /*
        * value 가 null 이면 NPE 가 발생하며
        * value 가 null 이 아니라면 equals 가 실행되므로  value != null 은 불필요한 코드이다.
        * value != null 를 먼저 비교한 후에 value.equals("") 를 실행하는 것이 올바른 방법이다.
        * */
        if (!value.equals("") && value != null) {
            return false;
        }
        
        return true;
    }
}
