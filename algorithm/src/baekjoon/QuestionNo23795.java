package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo23795 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));

        String str;
        int total = 0;
        while (!(str = inputStreamReader.readLine()).equals("-1")) {
            int num = Integer.parseInt(str);
            total += num;
        }

        System.out.println(total);
    }
}
