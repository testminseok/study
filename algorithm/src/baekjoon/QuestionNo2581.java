package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(inputStreamReader.readLine());
        int end = Integer.parseInt(inputStreamReader.readLine());
        boolean[] arr = new boolean[end + 1];

        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i]) continue;
            for (int j = i * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }

        int total = 0;
        int min = -1;
        for (int i = start; i <= end; i++) {
            if (!arr[i]) {
                total += i;
                if (min == -1) {
                    min = i;
                }
            }
        }

        if (total == 0) {
            System.out.println("-1");
        } else {
            System.out.println(total);
            System.out.println(min);
        }
    }
}
