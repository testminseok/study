package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo1598 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int width = Math.abs(getX(A) - getX(B));
        int height = Math.abs(getY(A) - getY(B));

        System.out.println(width + height);
    }

    private static int getY(int a) {
        int range = 4;
        while (range < a) {
            range += 4;
        }
        return range - a;
    }

    private static int getX(int a) {
        int range = 4;
        int row = 1;
        while (range < a) {
            row++;
            range += 4;
        }
        return row;
    }
}
