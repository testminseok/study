package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int element = Integer.parseInt(stringTokenizer.nextToken());
                arr1[i][j] = element;
            }
        }

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int element = Integer.parseInt(stringTokenizer.nextToken());
                arr2[i][j] = element;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                builder.append(arr1[i][j] + arr2[i][j]).append(" ");
            }
            builder.append("\n");
        }

        System.out.println(builder);
    }
}
