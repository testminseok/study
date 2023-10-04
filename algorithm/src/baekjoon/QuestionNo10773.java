package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionNo10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inputStreamReader.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(inputStreamReader.readLine());

            if (num == 0) {
                list.remove(list.size() - 1);
                continue;
            }

            list.add(num);
        }

        int total = 0;
        for (int num : list) {
            total += num;
        }

        System.out.println(total);
    }
}
