package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        int w = Integer.parseInt(stringTokenizer.nextToken());
        int h = Integer.parseInt(stringTokenizer.nextToken());

        int right = w - x;
        int down = h - y;

        System.out.println(min(x, y, right, down));
    }

    private static int min(int... num) {
        int min = Integer.MAX_VALUE;
        for (int x : num) {
            min = Integer.min(min, x);
        }
        return min;
    }
}
