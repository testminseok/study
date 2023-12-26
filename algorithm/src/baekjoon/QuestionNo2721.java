package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2721 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(inputStreamReader.readLine());
            int sum = 0;
            for (int k = 1; k <= N; k++) {
                sum += k * sum(k + 1);
            }
            builder.append(sum).append("\n");
        }

        System.out.println(builder);
    }

    private static int sum(int num) {
        return num * (num + 1) / 2;
    }
}
