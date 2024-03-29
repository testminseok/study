package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inputStreamReader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int num = i;
            int total = 0;
            while (num != 0) {
                total += num % 10;
                num /= 10;
            }

            if (size == (i + total)) {
                builder.append(i);
                break;
            }
        }

        if (builder.length() == 0) {
            System.out.println("0");
        } else {
            System.out.println(builder);
        }
    }
}
