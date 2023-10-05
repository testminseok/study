package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            String str = inputStreamReader.readLine();
            if (str.length() % 2 != 0) {
                builder.append("NO").append("\n");
                continue;
            }

            while (str.contains("()")) {
                str = str.replaceAll("\\(\\)", "");
            }

            if (str.isEmpty()) {
                builder.append("YES").append("\n");
            } else {
                builder.append("NO").append("\n");
            }
        }

        System.out.println(builder);
    }
}
