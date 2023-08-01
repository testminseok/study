package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        final int size = 10;
        int[] buckets = new int[1000];
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(inputStreamReader.readLine());
            buckets[num % 42]++;
        }

        int result = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] >= 1) {
                result++;
            }
        }

        System.out.println(result);
    }
}
