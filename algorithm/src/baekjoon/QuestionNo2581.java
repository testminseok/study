package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(inputStreamReader.readLine());
        int end = Integer.parseInt(inputStreamReader.readLine());

        int total = 0;
        int min = -1;
        for (int i = start; i <= end; i++) {
            int cnt = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }

            if (cnt == 1) {
                total += i;
                if (min == -1) {
                    min = i;
                }
            }
        }

        if (total == 0) {
            System.out.println("-1");
        } else {
            System.out.println(total);
            System.out.println(min);
        }
    }
}
