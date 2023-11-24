package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class QuestionNo1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(inputStreamReader.readLine());
            BigInteger bigInteger = BigInteger.ZERO;
            for (int j = 0; j < N; j++) {
                long number = Long.parseLong(inputStreamReader.readLine());
                bigInteger = bigInteger.add(BigInteger.valueOf(number));
            }
            int compare = bigInteger.compareTo(BigInteger.ZERO);
            if (compare > 0) {
                stringBuilder.append("+");
            } else if (compare < 0) {
                stringBuilder.append("-");
            } else {
                stringBuilder.append("0");
            }

            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);

    }
}
