package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());

        long a = Long.parseLong(stringTokenizer.nextToken());
        long b = Long.parseLong(stringTokenizer.nextToken());
        long c = Long.parseLong(stringTokenizer.nextToken());

        System.out.println(a + b + c);
    }
}
