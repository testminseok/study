package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo27110 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());

        int sum = 0;
        while (stringTokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            sum += Math.min(num, N);
        }

        System.out.println(sum);
    }
}
