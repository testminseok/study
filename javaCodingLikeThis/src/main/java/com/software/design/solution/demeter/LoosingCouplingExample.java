package com.software.design.solution.demeter;

public class LoosingCouplingExample {
    public static void main(String[] args) {
        Customer ted = new Customer("C01", 1000);

        ted.deposit(100);
        ted.withdraw(90);
    }
}
