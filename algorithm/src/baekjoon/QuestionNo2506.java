package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int total = 0;
        int score = 1;
        for (int num : arr) {
            if (num != 0) {
                total += score;
                score++;
            }  else {
                score = 1;
            }
        }

        System.out.println(total);
    }
}
