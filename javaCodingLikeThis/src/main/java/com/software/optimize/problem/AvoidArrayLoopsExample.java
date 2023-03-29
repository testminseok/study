package com.software.optimize.problem;


/**
 * 11-2 리스트와 배열 간 빠른 복사 방법
 * - AvoidArrayLoops : 배열을 복사할 때 반복문을 통해 수동으로 복사하는 경우 수정을 권고한다.
 *                     Arrays.copyOf() 또는 System.arraycopy() 를 사용하자
 * */
public class AvoidArrayLoopsExample {
    public static void main(String[] args) {
        int[] source = new int[1_000_000];
        
        // 원본 배열에 값 입력
        for (int i = 0; i < source.length; i++) {
            source[i] = i;
        }
        
        AvoidArrayLoopsExample example = new AvoidArrayLoopsExample();
        example.copyByClone(source);
        example.copyByLoop(source);
    }

    private void copyByLoop(int[] source) {
        int[] target = new int[source.length];
        
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            for(int k = 0; k < source.length; k++) {
                target[k] = source[k];
            }
        }
        
        long end = System.currentTimeMillis();
        
        System.out.println("##반복문 실행시간 : " + (end - start)/1000.0f + "초");
    }

    private void copyByClone(int[] source) {
        long start = System.currentTimeMillis();
        int[] target;

        for(int i = 0; i < 100; i++) {
            target = source.clone();
        }

        long end = System.currentTimeMillis();

        System.out.println("##clone 실행시간 : " + (end - start)/1000.0f + "초");
    }
}
