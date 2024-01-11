package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int[] counts = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String str = inputStreamReader.readLine();

        for (int i = 0; i < str.length(); i++) {
            int charAt = str.charAt(i);
            counts[charAt - 97] += 1;
        }

        StringBuilder builder = new StringBuilder();
        for (int num : counts) {
            builder.append(num).append(" ");
        }

        System.out.println(builder);
    }
}
