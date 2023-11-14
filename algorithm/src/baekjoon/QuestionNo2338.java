package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class QuestionNo2338 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger A = new BigInteger(inputStreamReader.readLine());
        BigInteger B = new BigInteger(inputStreamReader.readLine());

        String str = A.add(B) + "\n" +
                A.subtract(B) + "\n" +
                A.multiply(B);

        System.out.println(str);
    }
}
