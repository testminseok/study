package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo15894 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        long maxSize = Long.parseLong(inputStreamReader.readLine());
        System.out.println(maxSize * 4);
    }
}
