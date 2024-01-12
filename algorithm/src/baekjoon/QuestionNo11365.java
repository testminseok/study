package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();
        String str;
        while (!(str = inputStreamReader.readLine()).equals("END")) {
            builder.append(new StringBuilder(str).reverse()).append("\n");
        }

        System.out.println(builder);
    }
}
