package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo11945 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            builder.append(new StringBuilder(inputStreamReader.readLine()).reverse()).append("\n");
        }

        System.out.println(builder);
    }
}
