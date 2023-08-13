package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < N; i++) {
            builder.append(" ".repeat(N - i));
            builder.append("*".repeat(i * 2 - 1));
            builder.append("\n");
        }

        for (int i = 0; i < N; i++) {
            builder.append(" ".repeat(i));
            builder.append("*".repeat(N * 2 - 1 - i * 2));
            builder.append("\n");
        }

        System.out.println(builder);
    }
}
