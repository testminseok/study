package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        int[] times = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int money = getYongSick(times);
        int money2 = getMinSick(times);

        if (money == money2) {
            System.out.printf("Y M %d", money);
        } else if (money > money2) {
            System.out.printf("M %d", money2);
        } else {
            System.out.printf("Y %d", money);
        }
    }

    private static int getMinSick(int[] times) {
        int money = 0;
        for (int time : times) {
            money += ((time / 60) + 1) * 15;
        }
        return money;
    }

    private static int getYongSick(int[] times) {
        int money = 0;
        for (int time : times) {
            money += ((time / 30) + 1) * 10;
        }
        return money;
    }
}
