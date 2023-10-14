package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class QuestionNo11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        Queue<Integer> integers = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            integers.add(i);
        }

        StringBuilder builder = new StringBuilder();
        builder.append("<");
        while (integers.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                int num = integers.poll();
                integers.offer(num);
            }

            builder.append(integers.poll()).append(", ");
        }

        builder.append(integers.poll()).append(">");
        System.out.println(builder);
    }
}
