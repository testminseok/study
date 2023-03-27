package com.software.design.problem.coupling;

public class Teller {
    // 은행이 공개돼 있어 모든 객체에서 접근할 수 있다.
    public Bank bank;

    public Teller() {
        bank = new Bank();
    }
}
