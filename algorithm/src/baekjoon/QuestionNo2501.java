package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class QuestionNo2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            if (N % i == 0) {
                list.add(i);
            }
        }

        if (list.size() < K) {
            System.out.println("0");
        } else {
            System.out.println(list.get(K - 1));
        }
        // 1 + 5 + 5^2
    }
}
