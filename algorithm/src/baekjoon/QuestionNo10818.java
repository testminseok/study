package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inputStreamReader.readLine());
        String[] arr = inputStreamReader.readLine().split(" ");

        int min = 0;
        int max = 0;
        for (String str : arr) {
            int num = Integer.parseInt(str);

            if(min == 0 && max == 0 ){
                min = num;
                max = num;
            }

            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }
        }

        System.out.printf("%d %d", min, max);
    }
}
