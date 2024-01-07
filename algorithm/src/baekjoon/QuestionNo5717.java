package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo5717 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();
        String str;
        while (!(str = inputStreamReader.readLine()).equals("0 0")) {
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int F = Integer.parseInt(stringTokenizer.nextToken());

            builder.append(M + F).append("\n");
        }

        System.out.println(builder);
    }
}
