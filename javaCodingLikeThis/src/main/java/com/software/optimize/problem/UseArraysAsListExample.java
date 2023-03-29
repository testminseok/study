package com.software.optimize.problem;

import java.util.ArrayList;
import java.util.List;

public class UseArraysAsListExample {
    public static void main(String[] args) {
        int size = 1_000_000;
        List<Integer> list = new ArrayList<>();

        Integer[] array = new Integer[size];

        // 반복문을 이용한 데이터 입력
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        long start = System.currentTimeMillis();

        // 반복문을 이용한 데이터 입력
        for (int i = 0; i < size; i++) {
            list.add(array[i]);
        }

        long end = System.currentTimeMillis();

        System.out.println("##실행시간 : " + (end - start)/1000.0f + "초");
    }
}
