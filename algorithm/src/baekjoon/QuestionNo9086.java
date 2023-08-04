package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inputStreamReader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            String str = inputStreamReader.readLine();
            builder.append(str.charAt(0)).append(str.charAt(str.length() - 1)).append("\n");
        }
        System.out.println(builder);
    }
}
