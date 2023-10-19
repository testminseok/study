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
        StringTokenizer stringTokenizer2 = new StringTokenizer(inputStreamReader.readLine(), " ");
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int type = Integer.parseInt(stringTokenizer.nextToken());
            int num = Integer.parseInt(stringTokenizer2.nextToken());
            // Stack 에 삽입된 요소는 사용되지 않으므로 Stack 자체를 제거
            if (type == 0) {
                deque.add(num);
            }
        }

        int M = Integer.parseInt(inputStreamReader.readLine());
        stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            deque.addFirst(num);
            builder.append(deque.pollLast()).append(" ");
        }

        System.out.println(builder);
    }
}
