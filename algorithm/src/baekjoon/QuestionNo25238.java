package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo25238 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
        double a = Double.parseDouble(stringTokenizer.nextToken());
        double b = Double.parseDouble(stringTokenizer.nextToken());
        double damage = a - ((a * b) / 100);
        if (damage >= 100) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
    }
}
