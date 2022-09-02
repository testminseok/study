package d.util;

import java.util.Arrays;

public class ArraysSample {
    public static void main(String[] args) {
        ArraysSample sample = new ArraysSample();
        sample.checkSort();
        sample.checkFill();
    }

    private void checkFill() {
        int[] emptyArray = new int[10];
        Arrays.fill(emptyArray, 1);
        Arrays.fill(emptyArray, 0, 5, 9);

        System.out.println(Arrays.toString(emptyArray));
    }

    private void checkSort() {
        int[] values = new int[]{1, 5, 3, 2, 4, 7, 6, 10, 8, 9};
        Arrays.sort(values);

        System.out.println(Arrays.toString(values));
    }
}
