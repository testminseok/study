package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class QuestionNo2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        char[] B = stringTokenizer.nextToken().toCharArray();
        int N = Integer.parseInt(stringTokenizer.nextToken());

        double total = 0;
        for (int i = 0; i < B.length; i++) {
            int num = Character.isAlphabetic(B[i]) ? B[i] - 55 : B[i] - 48;
            total += num * Math.pow(N, B.length - 1 - i);
        }
        System.out.println(new BigDecimal(total));
    }
}
