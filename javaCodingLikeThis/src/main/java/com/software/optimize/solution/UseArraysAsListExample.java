package com.software.optimize.solution;

import java.util.Arrays;
import java.util.List;

public class UseArraysAsListExample {
    public static void main(String[] args) {
        int size = 1_000_000;

        Integer[] array = new Integer[size];

        // 반복문을 이용한 데이터 입력
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        long start = System.currentTimeMillis();

        List<Integer> list = Arrays.asList(array);

        long end = System.currentTimeMillis();

        System.out.println("##실행시간 : " + (end - start)/1000.0f + "초");
    }
}
