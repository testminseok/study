package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo4470 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            String str = inputStreamReader.readLine();
            builder.append(i).append(".").append(" ")
                    .append(str).append("\n");
        }

        System.out.println(builder);
    }
}
