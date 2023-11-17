package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo4101 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String str;
        while (!(str = inputStreamReader.readLine()).equals("0 0")) {
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            if (A > B) {
                builder.append("Yes");
            } else {
                builder.append("No");
            }

            builder.append("\n");
        }

        System.out.println(builder);
    }
}
