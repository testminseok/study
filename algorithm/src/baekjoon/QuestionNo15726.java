package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo15726 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
        double A = Double.parseDouble(stringTokenizer.nextToken());
        double B = Double.parseDouble(stringTokenizer.nextToken());
        double C = Double.parseDouble(stringTokenizer.nextToken());

        System.out.println(Integer.max((int) (A * B / C), (int) (A / B * C)));
    }
}
