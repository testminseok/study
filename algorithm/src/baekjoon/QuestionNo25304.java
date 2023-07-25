package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(inputStreamReader.readLine());
        int totalCount = Integer.parseInt(inputStreamReader.readLine());

        int sum = 0;
        for (int i = 0; i < totalCount; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            int price = Integer.parseInt(stringTokenizer.nextToken());
            int count = Integer.parseInt(stringTokenizer.nextToken());
            sum += price * count;
        }

        System.out.println(total == sum ? "Yes" : "No");
    }
}
