package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String str = inputStreamReader.readLine();
        StringBuilder builder = new StringBuilder(str);
        builder.reverse();
        if (str.contentEquals(builder)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
