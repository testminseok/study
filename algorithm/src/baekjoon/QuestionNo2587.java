package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = 5;
        int[] arr = new int[size];
        int total = 0;
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(inputStreamReader.readLine());
            arr[i] = num;
            total += num;
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

        System.out.println(total / size);
        System.out.println(arr[size / 2]);

    }
}
