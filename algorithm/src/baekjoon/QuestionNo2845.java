package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int L = Integer.parseInt(stringTokenizer.nextToken());
        int P = Integer.parseInt(stringTokenizer.nextToken());

        int total = L * P;
        stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        StringBuilder builder = new StringBuilder();
        while (stringTokenizer.hasMoreTokens()) {
            int N = Integer.parseInt(stringTokenizer.nextToken());
            builder.append(N - total).append(" ");
        }

        System.out.println(builder);
    }
}
