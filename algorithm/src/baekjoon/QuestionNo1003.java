package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo1085 {
    private static int zero = 0;
    private static int one = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            fibonacci(N);
            builder.append(zero);
            builder.append(" ");
            builder.append(one);
            builder.append("\n");
            zero = 0;
            one = 0;
        }
    }

    private static int fibonacci(int n) {
        if (n == 0)  {
            zero++;
            return 0;
        } else if (n == 1) {
            one++;
            return 1;
        } 

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
