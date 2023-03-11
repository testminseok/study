package com.software.basic.problem;

import java.util.Arrays;

/**
 * 8-5 복잡한 메소드는 재앙이다
 * - CyclomaticComplexity : PMD 는 메소드의 복잡성을 평가하고 수정을 권고한다.
 *                          - 1~4점은 낮은 복잡도, 5~7점은 중간 복잡도, 8~9점은 높은 복잡도, 11점 이상은 매우 높은 단계의 복잡도로 진단하고 수정을 권고한다.
 *                          - 메소드는 기본 1점
 *                          - 점수 기준 모든 제어흐름 문(if, case, catch, throw, do, while, for, break, continue) 및 조건식 (?:) 에 대해 +1 점
 *                            switch 케이스는 하나로 계산 되지만 switch 자체는 계산되지 않는다.
 *                          - else, finally, default 문은 점수에 포함하지 않는다.
 *                          - 제어 흐름문에 있는 조건에 모든 boolean 연산자 (&&, ||) 대해 +1점
 */
public class CyclomaticComplexityExample {
    public static void main(String[] args) {
        badCode();
        goodCode();
    }

    private static void goodCode() { // Cyclo = 1
        int[] array = {0, 3, 5, 2, 6, 7, 8, 9, 1, 4};
        int[] sortedArray = new int[array.length];

        // 단 한 줄로 배열을 정렬할 수 있다.
        Arrays.sort(array);

        // 메소드 하나로 배열을 복사할 수 있다.
        System.arraycopy(array, 0, sortedArray, 0, array.length);

        System.out.println("최종 결과");
        for (int v : sortedArray) { // +1
            System.out.printf(v + " ");
        }
    }

    private static void badCode() { // cyclo = 9
        int[] array = {0, 3, 5, 2, 6, 7, 8, 9, 1, 4};
        int[] sortedArray = new int[array.length];
        int temp;

        try {
            if (array.length > 0) { // +1
                if (sortedArray.length > 0) { // +1
                    for (int i = 0; i < array.length; i++) { // +1
                        for (int k = i + 1; k < array.length; k++) { // +1
                            if (array[i] > array[k]) { // +1
                                temp = array[i];
                                array[i] = array[k];
                                array[k] = temp;
                            }
                        }

                        for (int v : array) { // +1
                            System.out.print(v + " ");
                        }
                        System.out.println("\n");
                    }

                    for (int i = 0; i < array.length; i++) { // +1
                        sortedArray[i] = array[i];
                    }
                }
            }

            System.out.println("최종결과");
            for (int v : sortedArray) { // +1
                System.out.print(v + " ");
            }
        } catch (Exception e) { // +1
            e.printStackTrace();
        }
    }
}
