package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        if (N == 1) {
            System.out.println("1/1");
        } else {
            int range = 1; // 범위
            int line = 0; // 대각선 수
            while (range <= N) {
                line++;
                range += line;
            }

            int position = range - N; // 대각선 상의 위치
            int num = (line + 1) - position; // 분모 또는 분자
            boolean isRight = line % 2 == 0; // 대각선 위에서 아래로 내려오는지
            int numerator = isRight ? num : position;
            int denominator = isRight ? position : num;

            System.out.println(numerator + "/" + denominator);
            
        }
    }
}
