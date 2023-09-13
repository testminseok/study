package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inputStreamReader.readLine());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(inputStreamReader.readLine());
            arr[i] = num;
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int num : arr) {
            builder.append(num).append("\n");
        }
        System.out.println(builder);
    }
}
