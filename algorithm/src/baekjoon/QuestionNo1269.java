package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QuestionNo1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int aSize = Integer.parseInt(stringTokenizer.nextToken());
        int bSize = Integer.parseInt(stringTokenizer.nextToken());

        Set<String> A = new HashSet<>();
        stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        for (int i = 0; i < aSize; i++) {
            A.add(stringTokenizer.nextToken());
        }

        Set<String> B = new HashSet<>();
        stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        for (int i = 0; i < bSize; i++) {
            B.add(stringTokenizer.nextToken());
        }

        Set<String> list = new HashSet<>(A);
        list.removeAll(B);

        Set<String> list2 = new HashSet<>(B);
        list2.removeAll(A);

        System.out.println(list.size() + list2.size());
    }
}
