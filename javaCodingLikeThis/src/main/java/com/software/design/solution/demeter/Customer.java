package com.software.design.solution.demeter;

public class Customer {
    private String customerCode;
    private int value;
    private Teller teller;

    public Customer(String customerCode, int value) {
        this.customerCode = customerCode;
        this.value = value;
        teller = new Teller();
    }

    /**
     * 출금
     * @param value 출금 금액
     * @return 출금 성공 여부
     * */
    public boolean withdraw(int value) {
        boolean withdraw = teller.withdraw(customerCode, value);
        if (withdraw) {
            this.value -= value;
        }
        return withdraw;
    }

    /**
     * 입금
     * @param value 입금 금액
     * @return 입금 성공 여부
     * */
    public boolean deposit(int value) {
        boolean deposit = teller.deposit(customerCode, value);
        if (deposit) {
            this.value += value;
        }
        return deposit;
    }

}
