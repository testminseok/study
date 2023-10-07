package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder builder = new StringBuilder();
        while (!(str = inputStreamReader.readLine()).equals(".")) {
            str = str.replaceAll("[^()\\[\\]]", "");
            if (str.length() % 2 != 0) {
                builder.append("no").append("\n");
                continue;
            }
            while (str.contains("()") || str.contains("[]")) {
                str = str.replaceAll("\\(\\)", "").replaceAll("\\[]", "");
            }
            if (str.isEmpty()) {
                builder.append("yes").append("\n");
            } else {
                builder.append("no").append("\n");
            }
        }

        System.out.println(builder);
    }
}
