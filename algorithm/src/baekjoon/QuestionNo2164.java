package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class QuestionNo2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        ArrayDeque<Integer> integers = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            integers.add(i);
        }

        while (integers.size() > 1) {
            integers.pop();
            integers.addLast(integers.pop());
        }

        System.out.println(integers.pop());

    }
}
