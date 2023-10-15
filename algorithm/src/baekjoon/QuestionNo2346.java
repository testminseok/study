package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class QuestionNo2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");

        ArrayDeque<int[]> integers = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            integers.add(new int[] {i, num});
        }

        StringBuilder builder = new StringBuilder();
        int[] first = integers.pop();
        builder.append(first[0]).append(" ");
        int next = first[1];
        while (!integers.isEmpty()) {
            if (next > 0) {
                for (int j = 1; j < next; j++) {
                    integers.add(integers.pollFirst());
                }
                int[] removeFirst = integers.removeFirst();
                next = removeFirst[1];
                builder.append(removeFirst[0]).append(" ");
            } else {
                for (int j = next; j < -1; j++) {
                    integers.addFirst(integers.pollLast());
                }

                int[] removeLast = integers.removeLast();
                next = removeLast[1];
                builder.append(removeLast[0]).append(" ");
            }
        }

        System.out.println(builder);
    }
}
