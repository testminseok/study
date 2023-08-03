package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inputStreamReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");

        double totalScore = 0;
        int max = 0;
        for (int i = 0; i < size; i++) {
            int score = Integer.parseInt(stringTokenizer.nextToken());
            totalScore += score;
            if (score > max) {
                max = score;
            }
        }

        System.out.println(totalScore / max * 100 / size);
    }
}
