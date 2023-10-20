package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        // N까지의 숫자 중 약수의 개수가 홀수인 숫자만
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            count++;
        }

        System.out.println(count);
    }
}
