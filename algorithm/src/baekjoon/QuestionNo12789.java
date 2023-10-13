package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QuestionNo12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");

        Queue<Integer> integers = new LinkedList<>();
        Stack<Integer> integers1 = new Stack<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            integers.add(num);
        }

        int waitingNumber = 1;

        while (!integers.isEmpty()) {
            int peek = integers.peek();
            if (waitingNumber == peek) {
                integers.poll();
                waitingNumber++;
            } else if (!integers1.isEmpty() && waitingNumber == integers1.peek()) {
                integers1.pop();
                waitingNumber++;
            } else {
                integers1.push(integers.poll());
            }

        }

        while (!integers1.isEmpty()) {
            int peek = integers1.peek();
            if (waitingNumber == peek) {
                integers1.pop();
                waitingNumber++;
            } else {
                break;
            }
        }

        if (integers.isEmpty() && integers1.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
