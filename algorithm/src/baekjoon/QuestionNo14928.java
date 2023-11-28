package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo14928 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String str = inputStreamReader.readLine();

        int length = str.length();
        int remainder = 0;
        for (int i = 0; i < length; i++) {
            remainder = (remainder * 10 + Character.getNumericValue(str.charAt(i))) % 20000303;
        }

        System.out.println(remainder);
    }
}
