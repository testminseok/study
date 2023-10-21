package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        boolean[] arr = new boolean[N + 1];

        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i <= Math.sqrt(N + 1); i++) {
            if (arr[i]) continue;
            for (int j = i * i; j < N + 1; j += i) {
                arr[j] = true;
            }
        }

        for (int i = M; i < N + 1; i++) {
            if (!arr[i]) {
                System.out.println(i);
            }
        }
    }
}
