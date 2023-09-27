package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class QuestionNo10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, String> map = new HashMap<>();
        // 듣도 못한 사람
        for (int i = 0; i < N; i++) {
            map.put(inputStreamReader.readLine(), "");
        }

        Map<String, String> map2 = new TreeMap<>();
        // 보도 못한 사람
        for (int i = 0; i < M; i++) {
            String key = inputStreamReader.readLine();
            if (map.containsKey(key)) {
                map2.put(key, "");
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(map2.size()).append("\n");
        for (String key : map2.keySet()) {
            builder.append(key).append("\n");
        }

        System.out.println(builder);
    }
}
