package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(inputStreamReader.readLine());
        int B = Integer.parseInt(inputStreamReader.readLine());
        System.out.println(A + B);
    }
}
