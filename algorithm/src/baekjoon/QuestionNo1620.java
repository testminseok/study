package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QuestionNo1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String key = inputStreamReader.readLine();
            int index = i + 1;
            map.put(key, index);
            map2.put(index, key);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String str = inputStreamReader.readLine();
            try {
                int index = Integer.parseInt(str);
                builder.append(map2.get(index)).append("\n");
            } catch (NumberFormatException numberFormatException) {
                builder.append(map.get(str)).append("\n");
            }

        }

        System.out.println(builder);
    }
}
