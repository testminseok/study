package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class QuestionNo15740 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
        BigInteger A = new BigInteger(stringTokenizer.nextToken());
        BigInteger B = new BigInteger(stringTokenizer.nextToken());

        System.out.println(A.add(B));
    }
}
