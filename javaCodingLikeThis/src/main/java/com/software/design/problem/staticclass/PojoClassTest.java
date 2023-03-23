package com.software.design.problem.staticclass;

import com.software.design.problem.staticclass.PojoClassExample;

public class PojoClassTest {
    public static void main(String[] args) {
        PojoClassExample example = new PojoClassExample();
        System.out.println(example.isEmpty("")); // true
        System.out.println(example.changeMoney("1234"));
    }
}
