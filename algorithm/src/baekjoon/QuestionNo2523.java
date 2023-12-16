package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2523 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // 별표입력
            builder.append("*".repeat(i + 1));
            // 공백입력
            builder.append("\n");
        }

        for (int i = 1; i < N; i++) {
            // 별표입력
            builder.append("*".repeat(N - i));
            // 공백입력
            builder.append("\n");
        }

        System.out.println(builder);
    }
}
