package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class QuestionNo4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder builder = new StringBuilder();
        while(!(str = inputStreamReader.readLine()).equals(".")) {
            builder.append(result(str)).append("\n");
        }

        System.out.println(builder);
    }

    private static String result(String str) {
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '(' || charAt == '[') {
                characters.push(charAt);
                continue;
            }

            if (charAt == ')') {
                if (characters.isEmpty() || characters.peek() != '(') {
                    return "no";
                } else {
                    characters.pop();
                }
            }

            if (charAt == ']') {
                if (characters.isEmpty() || characters.peek() != '[') {
                    return "no";
                } else {
                    characters.pop();
                }
            }
        }

        if (characters.isEmpty()) {
            return "yes";
        }

        return "no";
    }
}
