package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = inputStreamReader.readLine()) != null) {
            int num = Integer.parseInt(str);

            if (0 > num) {
                break;
            }

            if (num % 2 != 0) {
                System.out.println(num + " is NOT perfect.");
                continue;
            }

            int total = 0;
            StringBuilder builder = new StringBuilder();
            builder.append(num).append(" = ");
            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    builder.append(i).append(" + ");
                    total += i;
                }
            }

            if (num == total) {
                System.out.println(builder.substring(0, builder.lastIndexOf(" + ")));
            } else {
                System.out.println(num + " is NOT perfect.");
            }
        }
    }
}
