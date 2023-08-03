package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class QuestionNo10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");

        int size = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i + 1);
        }

        int count = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < count; i++) {
            stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            Collections.reverse(list.subList(start - 1, end));
        }

        StringBuilder builder = new StringBuilder();
        for (int index : list) {
            builder.append(index).append(" ");
        }
        System.out.println(builder);
    }
}
