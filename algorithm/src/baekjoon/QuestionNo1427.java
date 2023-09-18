package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuestionNo1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = inputStreamReader.readLine().split("");
        Arrays.sort(strings);
        StringBuilder builder = new StringBuilder();
        for (String num : strings) {
            builder.append(num);
        }
        builder.reverse();
        System.out.println(builder);
    }
}
