package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class QuestionNo28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            int command = Integer.parseInt(stringTokenizer.nextToken());

            if (command == 1) {
                int x = Integer.parseInt(stringTokenizer.nextToken());
                integers.addFirst(x);
            }

            if (command == 2) {
                int x = Integer.parseInt(stringTokenizer.nextToken());
                integers.addLast(x);
            }

            if (command == 3) {
                if (integers.isEmpty()) {
                    builder.append("-1").append("\n");
                } else {
                    builder.append(integers.pollFirst()).append("\n");
                }
            }

            if (command == 4) {
                if (integers.isEmpty()) {
                    builder.append("-1").append("\n");
                } else {
                    builder.append(integers.pollLast()).append("\n");
                }
            }

            if (command == 5) {
                builder.append(integers.size()).append("\n");
            }

            if (command == 6) {
                if (integers.isEmpty()) {
                    builder.append("1").append("\n");
                } else {
                    builder.append("0").append("\n");
                }
            }

            if (command == 7) {
                if (integers.isEmpty()) {
                    builder.append("-1").append("\n");
                } else {
                    builder.append(integers.peekFirst()).append("\n");
                }
            }

            if (command == 8) {
                if (integers.isEmpty()) {
                    builder.append("-1").append("\n");
                } else {
                    builder.append(integers.peekLast()).append("\n");
                }
            }
        }

        System.out.println(builder);

    }
}
