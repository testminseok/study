package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuestionNo5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Arrays.stream(inputStreamReader.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        int num2 = Arrays.stream(inputStreamReader.readLine().split(" ")).mapToInt(Integer::parseInt).sum();

        System.out.println(Integer.max(num1, num2));
    }
}
