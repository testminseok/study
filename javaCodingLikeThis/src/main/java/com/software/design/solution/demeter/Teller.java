package com.software.design.solution.demeter;

public class Teller {
    // 창구 직원만 직접 은행의 출금 절차에 접근할 수 있다.
    private Bank bank;

    public Teller() {
        bank = new Bank();
    }

    public boolean withdraw(String customerCode, int value) {
        return bank.withdraw(customerCode, value);
    }

    public boolean deposit(String customerCode, int value) {
        return bank.deposit(customerCode, value);
    }

    public boolean createCustomer(String customerCode, int value) {
        return bank.createCustomer(customerCode, value);
    }
}
