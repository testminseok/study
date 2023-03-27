package com.software.design.solution.demeter;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Integer> safe;

    public Bank() {
        safe = new HashMap<>();
    }

    private boolean isCustomer(String customerCode) {
        return safe.containsKey(customerCode);
    }

    private boolean isEnable(String customerCode, int value) {
        return safe.get(customerCode) >= value;
    }

    /**
     * 출금
     * @param customerCode 고객 코드
     * @param value 출금 금액
     * @return 출금 성공 여부
     * */
    public boolean withdraw(String customerCode, int value) {
        // 등록된 고객 이고 잔액이 부족하면 출금할 수 없다.
        if (isCustomer(customerCode) && isEnable(customerCode, value)) {
            safe.remove(customerCode);
            safe.put(customerCode, safe.get(customerCode) - value);
            return true;
        }
        return false;
    }

    /**
     * 입금
     * @param customerCode 고객 코드
     * @param value 입금 금액
     * @return 입금 성공 여부
     * */
    public boolean deposit(String customerCode, int value) {
        // 등록된 고객이 아니면 입금할 수 없다.
        if (isCustomer(customerCode)) {
            safe.remove(customerCode);
            safe.put(customerCode, safe.get(customerCode) + value);
            return true;
        }
        return false;
    }

    /**
     * 고객 등록
     * @param customerCode 고객 코드
     * @param value 입금 금액
     * @return 고객 등록 성공 여부
     * */
    public boolean createCustomer(String customerCode, int value) {
        // 기존 고객이면 등록 불가
        if (!isCustomer(customerCode)) {
            safe.put(customerCode, value);
            return true;
        }
        return false;
    }
}
