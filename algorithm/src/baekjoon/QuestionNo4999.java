package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo4999 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int length = inputStreamReader.readLine().length();
        int doctorLength = inputStreamReader.readLine().length();

        if (length >= doctorLength) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }
    }
}
