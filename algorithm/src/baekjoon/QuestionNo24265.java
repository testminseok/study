package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QuestionNo24265 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(bufferedReader.readLine());
        System.out.println(N * (N - 1) / 2);
        System.out.println(2);
    }
}
