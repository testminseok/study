package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo9063 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inputStreamReader.readLine());

        int xMax = Integer.MIN_VALUE;
        int xMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            if (xMax < x) {
                xMax = x;
            }

            if (xMin > x) {
                xMin = x;
            }

            if (yMax < y) {
                yMax = y;
            }

            if (yMin > y) {
                yMin = y;
            }
        }

        int width = xMax - xMin;
        int height = yMax - yMin;
        System.out.println(width * height);
    }
}
