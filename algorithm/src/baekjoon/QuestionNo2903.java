package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int pointCount = Integer.parseInt(inputStreamReader.readLine());
        System.out.println((int) Math.pow(Math.pow(2, pointCount) + 1, 2));
    }
}
