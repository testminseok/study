package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
            int num1 = Integer.parseInt(stringTokenizer.nextToken());
            int num2 = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(num1 + num2);
        }
    }
}
