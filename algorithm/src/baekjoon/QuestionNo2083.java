package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo2083 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        StringBuilder builder = new StringBuilder();
        String str;
        while (!(str = inputStreamReader.readLine()).equals("# 0 0")) {
            stringTokenizer = new StringTokenizer(str);
            String name = stringTokenizer.nextToken();
            int age = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            if (age > 17 || weight >= 80) {
                builder.append(name).append(" ").append("Senior").append("\n");
            } else {
                builder.append(name).append(" ").append("Junior").append("\n");
            }
        }

        System.out.println(builder);
    }
}
