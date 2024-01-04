package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo5554 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(inputStreamReader.readLine()); // 집 -> 학교
        int B = Integer.parseInt(inputStreamReader.readLine()); // 학교 -> PC방
        int C = Integer.parseInt(inputStreamReader.readLine()); // PC방 -> 학원
        int D = Integer.parseInt(inputStreamReader.readLine()); // 학원 -> 집

        int min = (A + B + C + D) / 60;
        int sec = (A + B + C + D) % 60;

        System.out.println(min);
        System.out.println(sec);
    }
}
