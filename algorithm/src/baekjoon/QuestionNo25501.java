package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo25501 {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = inputStreamReader.readLine();
            count = 0;
            builder.append(isPalindrome(str)).append(" ").append(count).append("\n");
        }

        System.out.println(builder);
    }

    private static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }

    private static int recursion(String str, int l, int r) {
        count++;
        if (l >= r) {
            return 1;
        }

        if (str.charAt(l) != str.charAt(r)) {
            return 0;
        }

        return recursion(str, l + 1, r - 1);
    }
}
