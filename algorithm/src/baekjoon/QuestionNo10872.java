package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        System.out.println(fac(N));
    }

    private static int fac(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * fac(n - 1);
    }
}
