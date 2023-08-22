package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inputStreamReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());

            // 약수의 갯수
            int total = 0;
            for (int j = 1; j <= num; j++) {
                if (num % j == 0) {
                    total++;
                }
            }

            // 소수는 1 과 자기 자신 만을 약수로 가진 수 (2개)
            if (total == 2) {
                sum++;
            }
        }

        System.out.println(sum);
    }
}
