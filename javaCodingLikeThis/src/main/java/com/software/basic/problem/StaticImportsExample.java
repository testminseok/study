package com.software.basic.problem;

import static java.lang.Boolean.*;
import static java.lang.Long.MAX_VALUE;
import static java.lang.Long.MIN_VALUE;
import static java.lang.Math.PI;
import static java.util.Calendar.*;

/**
 * 6-3 너무 많은 정적 참조는 불필요하다.
 * - TooManyStaticImports : 정적 참조가 4개 이상일 경우 경고하고 수정하도록 권고한다.
 *                          너무 많은 정적 참조는 가독성이 나빠지며, 모든 정적 멤버로 인해 네임스페이스가 오염될 수 있다.
 *                          이후 유지보수할 때에 정적 멤버가 어느 클래스에서 오는지 알 수 없다.
 */
public class StaticImportsExample {
    public static void main(String[] args) {
        System.out.println(PI);
        System.out.println(TRUE);
        System.out.println(FALSE);
        System.out.println(MAX_VALUE);
        System.out.println(MIN_VALUE);
        System.out.println(YEAR + "-" + (MONTH + 1) + "-" + DATE);
    }
}
