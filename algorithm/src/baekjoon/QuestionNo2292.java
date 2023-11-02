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
            int t = 0;
            int num = 1;
            while (t <= 1_000_000_000) {
                t += 6;
                num += t;
                if (N <= num) {
                    System.out.println((t / 6) + 1);
                    break;
                }
            }
        }

    }
}
