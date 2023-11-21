package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo5522 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int totalScore = 0;
        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(inputStreamReader.readLine());
            totalScore += score;
        }

        System.out.println(totalScore);
    }
}
