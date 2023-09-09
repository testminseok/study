package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo24313 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
        int a1 = Integer.parseInt(stringTokenizer.nextToken());
        int a0 = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(inputStreamReader.readLine());
        int n0 = Integer.parseInt(inputStreamReader.readLine());

        if (a1 * n0 + a0 <= c * n0 && c >= a1) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
