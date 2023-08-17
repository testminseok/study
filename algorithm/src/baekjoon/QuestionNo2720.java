package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(inputStreamReader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < testCaseNum; i++) {
            int money = Integer.parseInt(inputStreamReader.readLine());
            int quarter = money / 25;
            int dime = money % 25 / 10;
            int nickel = money % 25 % 10 / 5;
            int penny = money % 25 % 10 % 5;
            builder.append(quarter).append(" ");
            builder.append(dime).append(" ");
            builder.append(nickel).append(" ");
            builder.append(penny).append("\n");
        }
        System.out.println(builder);
    }
}
