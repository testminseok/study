package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        int[][] arr = new int[44][2];
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(inputStreamReader.readLine());

            for (int j = 0; j <= num; j++) {
                arr[j + 2][0] = arr[j][0] + arr[j + 1][0];
                arr[j + 2][1] = arr[j][1] + arr[j + 1][1];
            }
            builder.append(arr[num][0]).append(" ").append(arr[num][1]).append("\n");
        }

        System.out.println(builder);
    }
}
