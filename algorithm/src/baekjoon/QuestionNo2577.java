package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(inputStreamReader.readLine());
        int B = Integer.parseInt(inputStreamReader.readLine());
        int C = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();
        String[] str = String.valueOf(A * B * C).split("");
        for (int i = 0; i < 10; i++) {
            int cnt = 0;
            for (String string : str) {
                if (string.equals(String.valueOf(i))) {
                    cnt++;
                }
            }

            builder.append(cnt).append("\n");
        }

        System.out.println(builder);
    }
}
