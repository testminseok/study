package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QuestionNo1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inputStreamReader.readLine());
        List<Map<String, Integer>> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            HashMap<String, Integer> element = new HashMap<>();
            element.put("x", x);
            element.put("y", y);
            list.add(element);
        }

        list.sort((x1, x2) -> {
            int compare = Integer.compare(x1.get("x"), x2.get("x"));
            if (compare == 0) {
                return Integer.compare(x1.get("y"), x2.get("y"));
            }else {
                return Integer.compare(x1.get("x"), x2.get("x"));
            }

        });

        StringBuilder builder = new StringBuilder();
        for (Map<String, Integer> element : list) {
            builder.append(element.get("x")).append(" ").append(element.get("y")).append("\n");
        }
        System.out.println(builder);
    }
}
