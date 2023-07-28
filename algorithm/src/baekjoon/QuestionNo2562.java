package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int maxSize = 9;

        int max = 0;
        int index = -1;
        for (int i = 0; i < maxSize; i++) {
            int num = Integer.parseInt(inputStreamReader.readLine());
            if (num > max) {
                max = num;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index + 1);
    }
}
