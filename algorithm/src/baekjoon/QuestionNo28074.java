package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo28074 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String str = inputStreamReader.readLine();
        boolean isMobis = str.contains("M") && str.contains("O") && str.contains("B") && str.contains("I") && str.contains("S");

        if (str.length() < 5 || !isMobis) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
