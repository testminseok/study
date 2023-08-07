package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = 9, max = 0, x = 0, y = 0;
        for (int i = 0; i < size; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            for (int j = 0; j < size; j++) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                if (num >= max) {
                    max = num;
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        System.out.println(max + "\n" + x + " " + y);
    }
}
