package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QuestionNo24267 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(bufferedReader.readLine());

        // 1 : 5 + 4 + 3 + 2 + 1 // 15
        // 2 : 4 + 3 + 2 + 1 // 10
        // 3 : 3 + 2 + 1 // 6
        // 4 : 2 + 1 // 3
        // 5 : 1

        long count = 0;
        for (long i = N - 1; i > 0; i--) {
            long num = i * (i - 1) / 2;
            count += num;

        }
        System.out.println(count);
        System.out.println(3);
    }
}
