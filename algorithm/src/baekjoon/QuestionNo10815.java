package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class QuestionNo10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String key = stringTokenizer.nextToken();
            map.put(key, key);
        }

        int M = Integer.parseInt(inputStreamReader.readLine());
        stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (map.containsKey(stringTokenizer.nextToken())) {
                builder.append("1");
            } else {
                builder.append("0");
            }
            builder.append(" ");
        }

        System.out.println(builder);

    }
}
