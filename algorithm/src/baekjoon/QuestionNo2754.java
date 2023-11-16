package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class QuestionNo2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> score = new HashMap<>();
        score.put("A+", 4.3);
        score.put("A0", 4.0);
        score.put("A-", 3.7);
        score.put("B+", 3.3);
        score.put("B0", 3.0);
        score.put("B-", 2.7);
        score.put("C+", 2.3);
        score.put("C0", 2.0);
        score.put("C-", 1.7);
        score.put("D+", 1.3);
        score.put("D0", 1.0);
        score.put("D-", 0.7);
        score.put("F", 0.0);

        System.out.println(score.get(inputStreamReader.readLine()));
    }
}
