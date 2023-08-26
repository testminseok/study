package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo27323 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int height = Integer.parseInt(inputStreamReader.readLine());
        int width = Integer.parseInt(inputStreamReader.readLine());
        System.out.println(height * width);
    }
}
