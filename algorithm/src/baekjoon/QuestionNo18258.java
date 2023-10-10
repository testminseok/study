package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class QuestionNo18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();
        Queue<Integer> integers = new LinkedList<>();
        int lastValue = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            String input = stringTokenizer.nextToken();
            if ("push".equals(input)) {
                int x = Integer.parseInt(stringTokenizer.nextToken());
                lastValue = x;
                integers.add(x);
            }

            if ("pop".equals(input)) {
                if (integers.isEmpty()){
                    builder.append("-1").append("\n");
                } else {
                    builder.append(integers.poll()).append("\n");
                }
            }

            if ("size".equals(input)) {
                builder.append(integers.size()).append("\n");
            }

            if ("empty".equals(input)) {
                if (integers.isEmpty()) {
                    builder.append("1").append("\n");
                } else {
                    builder.append("0").append("\n");
                }
            }

            if ("front".equals(input)) {
                if (integers.isEmpty()) {
                    builder.append("-1").append("\n");
                } else {
                    builder.append(integers.peek()).append("\n");
                }
            }

            if ("back".equals(input)) {
                if (integers.isEmpty()) {
                    builder.append("-1").append("\n");
                } else {
                    builder.append(lastValue).append("\n");
                }
            }
        }

        System.out.println(builder);
    }
}
