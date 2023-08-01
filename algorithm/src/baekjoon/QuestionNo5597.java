package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));

        final int totalStudents = 30;
        final int submittedStudent = 28;

        int[] students = new int[totalStudents];
        for (int i = 0; i < submittedStudent; i++) {
            int attendanceNum = Integer.parseInt(inputStreamReader.readLine());
            students[attendanceNum - 1]++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) {
                builder.append(i + 1).append("\n");
            }
        }
        System.out.println(builder);
    }
}
