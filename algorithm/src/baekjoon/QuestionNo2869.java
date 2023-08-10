package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");

        double move = Integer.parseInt(stringTokenizer.nextToken());
        double slip = Integer.parseInt(stringTokenizer.nextToken());
        double height = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println((int) Math.ceil((height - slip) / (move - slip)));
    }
}
