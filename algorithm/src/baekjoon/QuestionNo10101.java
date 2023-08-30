package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuestionNo10101 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int[] angles = new int[3];
        for (int i = 0; i < 3; i++) {
            int angle = Integer.parseInt(inputStreamReader.readLine());
            angles[i] = angle;
        }

        int total = Arrays.stream(angles).sum();
        if (total != 180) {
            System.out.println("Error");
            return;
        }

        boolean isEquilateral = Arrays.stream(angles).allMatch(angle -> angle == 60);
        if (isEquilateral) {
            System.out.println("Equilateral");
            return;
        }

        long count = Arrays.stream(angles).distinct().count();
        if (count == 3) {
            System.out.println("Scalene");
        } else {
            System.out.println("Isosceles");
        }
    }
}
