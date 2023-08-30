package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo10101 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int[] angles = new int[3];
        int total = 0;
        for (int i = 0; i < 3; i++) {
            int angle = Integer.parseInt(inputStreamReader.readLine());
            angles[i] = angle;
            total += angle;
        }

        if (total != 180) {
            System.out.println("Error");
        } else {
            boolean isEquilateral = angles[0] == 60 && angles[1] == 60 && angles[2] == 60;
            if (isEquilateral) {
                System.out.println("Equilateral");
            } else {
                boolean isIsosceles = false;
                for (int i = 0; i < 3; i++) {
                    for (int j = i + 1; j < angles.length; j++) {
                        if (angles[i] == angles[j]) {
                            isIsosceles = true;
                            break;
                        }
                    }
                }
                if (isIsosceles) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            }
        }
    }
}
