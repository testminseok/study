package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int[] chessPiece = new int[]{1, 1, 2, 2, 2, 8};
        StringBuilder builder = new StringBuilder();
        for (int j : chessPiece) {
            int piece = Integer.parseInt(stringTokenizer.nextToken());
            builder.append(j - piece).append(" ");
        }
        System.out.println(builder);
    }
}
