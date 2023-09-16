package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuestionNo2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputStreamReader.readLine());
        }

        Arrays.sort(arr);

        StringBuilder builder = new StringBuilder();
        for (int num : arr) {
            builder.append(num).append("\n");
        }
        System.out.println(builder);
    }
}
