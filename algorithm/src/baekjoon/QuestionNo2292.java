package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        if (N == 1) {
            System.out.println(1);
        } else {
            // 1 = 1 , 6 = 2,     18 = 3 ,     36 = 4 ,     60 = 5
            // 1 * 0        2 * 3 = 6  3 * 6 = 18 , 4 * 9 = 36,   5 * 12 = 60, 6 * 15 = 90
            int i = 2;
            int j = 3;
            while (i * j < N - 1) {
                i++;
                j += 3;
            }
            System.out.println(i);
        }
    }
}
