package com.software.design.problem.coupling;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    // 은행 금고가 공개돼 있어 어디서든 직접적인 접근이 가능하다.
    public Map<String, Integer> safe;

    public Bank() {
        safe = new HashMap<>();
    }
}
