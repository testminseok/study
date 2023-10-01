package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(inputStreamReader.readLine());
        final int minValue = 1;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            if (A == minValue) {
                builder.append(B).append("\n");
                continue;
            }

            for (int j = minValue; ; j++) {
                int temp = A * j;
                if (temp % B == 0) {
                    builder.append(temp).append("\n");
                    break;
                }
            }
        }

        System.out.println(builder);
    }
}
