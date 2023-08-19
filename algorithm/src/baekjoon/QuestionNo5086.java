package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (!(str = inputStreamReader.readLine()).equals("0 0")) {
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            int num1 = Integer.parseInt(stringTokenizer.nextToken());
            int num2 = Integer.parseInt(stringTokenizer.nextToken());

            if (num2 % num1 == 0) {
                System.out.println("factor");
            } else if (num1 % num2 == 0) {
                System.out.println("multiple");
            } else {
                System.out.println("neither");
            }
        }
    }
}
