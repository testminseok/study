package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo2420 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
        long N = Long.parseLong(stringTokenizer.nextToken());
        long M = Long.parseLong(stringTokenizer.nextToken());

        System.out.println(Math.abs(N - M));
    }
}
