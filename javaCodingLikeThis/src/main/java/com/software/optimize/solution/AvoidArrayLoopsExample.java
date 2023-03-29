package com.software.optimize.solution;

public class AvoidArrayLoopsExample {
    public static void main(String[] args) {
        int[] source = new int[1_000_000];

        // 원본 배열에 값 입력
        for (int i = 0; i < source.length; i++) {
            source[i] = i;
        }

        AvoidArrayLoopsExample example = new AvoidArrayLoopsExample();
        example.copyByArrayCopy(source);
    }

    private void copyByArrayCopy(int[] source) {
        int[] target = new int[source.length];

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            System.arraycopy(source, 0, target, 0, source.length);
        }

        long end = System.currentTimeMillis();

        System.out.println("##arraycopy 실행시간 : " + (end - start)/1000.0f + "초");
    }
}
