package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QuestionNo24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        List<Collection<Integer>> collections = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            if (num == 1) {
                Stack<Integer> stack = new Stack<>();
                collections.add(stack);
            } else {
                Queue<Integer> queue = new LinkedList<>();
                collections.add(queue);
            }
        }

        stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            Collection<Integer> collection = collections.get(i);
            if (collection instanceof Stack) {
                Stack<Integer> stack = (Stack<Integer>) collection;
                stack.add(num);
            } else {
                Queue<Integer> queue = (Queue<Integer>) collection;
                queue.add(num);
            }
        }

        int M = Integer.parseInt(inputStreamReader.readLine());
        stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = 0; j < N; j++) {
                Collection<Integer> collection = collections.get(j);
                if (collection instanceof Stack) {
                    Stack<Integer> stack = (Stack<Integer>) collection;
                    stack.add(num);
                    num = stack.pop();
                } else {
                    Queue<Integer> queue = (Queue<Integer>) collection;
                    queue.add(num);
                    num = queue.poll();
                }
            }
            builder.append(num).append(" ");
        }

        System.out.println(builder);
    }
}
