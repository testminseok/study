package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        long A = Long.parseLong(stringTokenizer.nextToken());
        long B = Long.parseLong(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        long C = Long.parseLong(stringTokenizer.nextToken());
        long D = Long.parseLong(stringTokenizer.nextToken());

        // 최대공약수를 구한 뒤 분자에게도 통분해준다.
        long leastCommonMultiple = getLeastCommonMultiple(B, D);
        A *= leastCommonMultiple / B;
        C *= leastCommonMultiple / D;

        // 구해진 분자와 분모를 기약분수로 만들어 출력 (기약분수는 분자와 분모의 최대공약수로 약분한다.)
        long greatestCommonDivisor = getGreatestCommonDivisor(A + C, leastCommonMultiple);
        System.out.println((A + C) / greatestCommonDivisor + " " + leastCommonMultiple / greatestCommonDivisor);
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
