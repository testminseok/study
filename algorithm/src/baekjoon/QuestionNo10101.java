package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo10101 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int[] angles = new int[3];
        for (int i = 0; i < 3; i++) {
            int angle = Integer.parseInt(inputStreamReader.readLine());
            angles[i] = angle;
        }

        if (180 != angles[0] + angles[1] + angles[2]) {
            System.out.println("Error");
        } else if (angles[0] == 60 && angles[1] == 60 && angles[2] == 60) {
            System.out.println("Equilateral");
        } else if (angles[0] == angles[1] || angles[0] == angles[2] || angles[1] == angles[2]) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }
}
