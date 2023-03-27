package com.software.design.problem.coupling;

/**
 * 10-2 불필요한 클래스 간의 소통을 최소화한다.
 * - LowOfDemeter : 객체간의 불필요한 연결이 있을경우 수정을 권고한다.
 *                  데메테르의 법칙은 "친구한테만 말해(one talk to another)"라고 정의한다.
 *                  즉, 객체 간의 연결관계를 최소한으로 제한하는 것이 매우 중요하다.
 * */
public class LoosingCouplingExample {
    public static void main(String[] args) {
        Customer ted = new Customer("C01", 1000);
        Customer yuto = new Customer("C01", 1000);

        ted.deposit(100);
        ted.withdrawal(90);
    }
}
