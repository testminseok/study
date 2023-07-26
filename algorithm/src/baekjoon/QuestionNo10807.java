package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inputStreamReader.readLine());
        String[] arr = inputStreamReader.readLine().split(" ");
        String te = inputStreamReader.readLine();

        int total = 0;
        for (String str : arr) {
            if (str.equals(te)) total++;
        }

        System.out.println(total);

    }
}
