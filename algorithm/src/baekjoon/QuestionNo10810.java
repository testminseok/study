package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] baskets = new int[N];

        for (int i = 0; i < M; i++) {
            StringTokenizer solution = new StringTokenizer(inputStreamReader.readLine(), " ");
            int start = Integer.parseInt(solution.nextToken());
            int end = Integer.parseInt(solution.nextToken());
            int boll = Integer.parseInt(solution.nextToken());

            for (int j = start - 1; j < end; j++) {
                baskets[j] = boll;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            builder.append(baskets[i]).append(" ");
        }

        System.out.println(builder);
    }
}
