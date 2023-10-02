package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        long A = Long.parseLong(stringTokenizer.nextToken());
        long B = Long.parseLong(stringTokenizer.nextToken());

        System.out.println(getLeastCommonMultiple(A, B));
    }

    // 최소공배수를 구한다.
    private static long getLeastCommonMultiple(long a, long b) {
        return a * b / getGreatestCommonDivisor(a, b);
    }

    // 최대공약수를 구한다.
    private static long getGreatestCommonDivisor(long a, long b) {
        if (b == 0) {
            return a;
        }

        return getGreatestCommonDivisor(b, a % b);
    }
}
