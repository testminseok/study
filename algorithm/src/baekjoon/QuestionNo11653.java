package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                builder.append(i).append("\n");
                num /= i;
            }
        }

        if (num > 1) {
            builder.append(num);
        }
        System.out.println(builder);
    }
}
