package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class QuestionNo10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String card = stringTokenizer.nextToken();
            if (map.containsKey(card)) {
                map.put(card, map.get(card) + 1);
            } else {
                map.put(card, 1);
            }
        }

        int M = Integer.parseInt(inputStreamReader.readLine());
        stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String card = stringTokenizer.nextToken();
            builder.append(map.getOrDefault(card, 0)).append(" ");
        }

        System.out.println(builder);
    }
}
