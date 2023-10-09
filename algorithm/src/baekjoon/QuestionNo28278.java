package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class QuestionNo28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();
        Stack<Integer> integers = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            int input = Integer.parseInt(stringTokenizer.nextToken());

            if (input == 1) {
                int x = Integer.parseInt(stringTokenizer.nextToken());
                integers.push(x);
            }

            if (input == 2) {
                if (integers.isEmpty()) {
                    builder.append("-1").append("\n");
                } else {
                    builder.append(integers.pop()).append("\n");
                }
            }

            if (input == 3) {
                builder.append(integers.size()).append("\n");
            }

            if (input == 4) {
                builder.append(integers.isEmpty() ? "1" : "0").append("\n");
            }

            if (input == 5) {
                if (integers.isEmpty()) {
                    builder.append("-1").append("\n");
                } else {
                    builder.append(integers.peek()).append("\n");
                }
            }
        }

        System.out.println(builder);
    }
}
