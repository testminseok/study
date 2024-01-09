package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        double v = inputStreamReader.lines()
                .mapToInt(Integer::parseInt)
                .map(num -> Math.max(num, 40))
                .average().orElse(0);
        System.out.println((int) v);
    }
}
