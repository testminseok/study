package com.software.basic.problem;

/**
 * 1-18 복함 단항 연산은 가독성이 떨어진다.
 * - 특별한 경우거 어나묜 단한 연산자를 두 개 이상 사용하지 않는다.
 * - AvoidMultipleUnaryOperators : 복잡한 당항 연산자의 가독성 저해 문제를 진단하고 수정하도록 권고한다.
 */
public class UnaryExample {
    public static void main(String[] args) {
        // 오타 혹은 불필요하게 복잡하고 혼동되는 코드
        int i = - -1;
        int j = + - + 1;
        int z = ~~2;

        boolean b = !!true;
        boolean c = !!!true;

        int d = ~-2;
        int e = -~3;

        System.out.println(i); // 1
        System.out.println(j); // -1
        System.out.println(z); // 2
        System.out.println(b); // true
        System.out.println(c); // false
        System.out.println(d); // 1
        System.out.println(e); // 4
    }
}
