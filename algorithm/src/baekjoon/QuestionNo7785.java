package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class QuestionNo7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        Map<String, String> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            String name = stringTokenizer.nextToken();
            String state = stringTokenizer.nextToken();

            map.put(name, state);
        }

        StringBuilder builder = new StringBuilder();
        for (String name : map.keySet()) {
            if (map.get(name).equals("enter")) {
                builder.append(name).append("\n");
            }
        }
        System.out.println(builder);
    }
}
