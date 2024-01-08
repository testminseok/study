package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(inputStreamReader.readLine());
            total += Integer.max(score, 40);
        }

        System.out.println(total / 5);
    }
}
