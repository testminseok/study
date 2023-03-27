package com.software.design.problem.coupling;

public class Customer {
    public String customerCode;
    public int money;
    public Teller teller;

    public Customer(String customerCode, int money) {
        this.customerCode = customerCode;
        this.money = money;
        teller = new Teller();
    }

    /**
     * 출금
     * @param value 출금액
     * @return 출금 성공 여부
     * */
    public boolean withdrawal(int value) {
        int deposit = teller.bank.safe.getOrDefault(customerCode, 0);
        boolean result = false;
        if (deposit - value >= 0) {
            money += value;
            teller.bank.safe.remove(customerCode);
            teller.bank.safe.put(customerCode, deposit - value);
            result = true;
        }

        return result;
    }

    /**
     * 입금
     * @param value 입금액
     * @return 입금 성공 여부
     * */
    public boolean deposit(int value) {
        int deposit = teller.bank.safe.getOrDefault(customerCode, 0);
        boolean result = false;
        if (deposit + value >= 0) {
            money -= value;
            teller.bank.safe.remove(customerCode);
            teller.bank.safe.put(customerCode, deposit + value);
            result = true;
        }

        return result;
    }

}
