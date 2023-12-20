package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo2712 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
            double num = Double.parseDouble(stringTokenizer.nextToken());
            String unit = stringTokenizer.nextToken();

            if ("kg".equals(unit)) {
                builder.append(String.format("%.4f", num * 2.2046)).append(" lb").append("\n");
            }

            if ("lb".equals(unit)) {
                builder.append(String.format("%.4f", num * 0.4536)).append(" kg").append("\n");
            }

            if ("l".equals(unit)) {
                builder.append(String.format("%.4f", num * 0.2642)).append(" g").append("\n");
            }

            if ("g".equals(unit)) {
                builder.append(String.format("%.4f", num * 3.7854)).append(" l").append("\n");
            }
        }

        System.out.println(builder);
    }
}
