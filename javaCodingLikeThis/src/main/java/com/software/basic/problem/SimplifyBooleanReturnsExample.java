package com.software.basic.problem;

/**
 * 1-19 Boolean 값을 반환하는 코드는 단순하게
 * - SimplifyBooleanReturns : Boolean 을 반환할 때 불필요한 if-then-else 문을 사용하지 말고 수정하기를 권고한다.
 */
public class SimplifyBooleanReturnsExample {
    public static void main(String[] args) {
        System.out.println(isEvenNumber(2)); // bad
        System.out.println(isEvenNumberBySimplifyBooleanReturns(2)); // good
    }

    /**
     * 반복된 if-then-else 문을 제고하고 return 문에서 직접 비교하는 코드를 작성해 불필요한 코드를 제거하고
     * 가동성과 효율성을 향상시킬 수 있다.
     * */
    private static boolean isEvenNumberBySimplifyBooleanReturns(int number) {
        return number % 2 == 0;
    }

    private static boolean isEvenNumber(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
