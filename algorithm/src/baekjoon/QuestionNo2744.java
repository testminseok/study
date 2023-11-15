package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String str = inputStreamReader.readLine();

        int length = str.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (ch < 'a') {
                result.append((char)(ch + 32));
            } else {
                result.append((char)(ch - 32));
            }
        }

        System.out.println(result);
    }
}
