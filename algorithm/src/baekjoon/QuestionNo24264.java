package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QuestionNo24264 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        System.out.println((long) Math.pow(size, 2));
        System.out.println(2); // O(n^2)
    }
}
