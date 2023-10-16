package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        if (N % 5 == 0) {
            System.out.println(N / 5);
        } else {
            // 초기값은 -1
            int count = -1;
            // 5키로 포대를 최대 갯수 부터 1개씩 빼면서 3키로 포대 갯수를 구한다.
            for (int i = N / 5; i >= 0; i--) {
                int num = N - (5 * i);
                if (num % 3 == 0) {
                    count = i + num / 3;
                    break;
                }
            }

            System.out.println(count);
        }
    }
}
