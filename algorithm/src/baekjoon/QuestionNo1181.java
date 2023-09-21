package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QuestionNo1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());
        Set<String> list = new TreeSet<>((str1, str2) -> {
            int compare = Integer.compare(str1.length(), str2.length());
            if (compare == 0) {
                return str1.compareTo(str2);
            }
            return compare;
        });

        for (int i = 0; i < N; i++) {
            list.add(inputStreamReader.readLine());
        }

        StringBuilder builder = new StringBuilder();
        for (String str : list) {
            builder.append(str).append("\n");
        }

        System.out.println(builder);
    }
}
