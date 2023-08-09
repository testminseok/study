package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int B = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        StringBuilder builder = new StringBuilder();
        while (B > 0) {
            if (B % N < 10) {
                builder.append(B % N);
            } else {
                builder.append((char) (B % N + 55));
            }
            B /= N;
        }

        System.out.println(builder.reverse());
    }
}
