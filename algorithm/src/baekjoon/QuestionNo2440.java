package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                builder.append("*");
            }
            builder.append("\n");
        }

        System.out.println(builder);
    }
}
