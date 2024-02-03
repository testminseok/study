package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class QuestionNo1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());

        BigInteger N = new BigInteger(stringTokenizer.nextToken());
        BigInteger M = new BigInteger(stringTokenizer.nextToken());

        System.out.println(N.divide(M));
        System.out.println(N.remainder(M));
    }
}
