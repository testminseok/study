package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        // 1 / 3 / 6 / 10
        if (N == 1) {
            System.out.println("1/1");
        } else {
            int range = 1;
            int num = 0;
            boolean right = true;
            while (range <= N) {
                num++;
                range += num;
                right = !right;
            }

            if (right) {
                System.out.println((num + 1) - (range - N) + "/" + (range - N));
            } else {
                System.out.println((range - N) + "/" + ((num + 1) - (range - N)));
            }
        }
    }
}
