package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        final int maxSize = 10000;
        int[] xArr = new int[maxSize];
        int[] yArr = new int[maxSize];

        for (int i = 0; i < 3; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            xArr[x]++;
            yArr[y]++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < maxSize; i++) {
            if (xArr[i] == 1) {
                builder.append(i).append(" ");
            }
        }

        for (int i = 0; i < maxSize; i++) {
            if (yArr[i] == 1) {
                builder.append(i);
            }
        }

        System.out.println(builder);
    }
}
