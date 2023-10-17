package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class QuestionNo18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStreamReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] sortedArr = new int[N];
        System.arraycopy(arr, 0, sortedArr, 0, sortedArr.length);
        Arrays.sort(sortedArr);

        Map<Integer, Integer> integerMap = new HashMap<>();
        int index = 0;
        for (int num : sortedArr) {
            if (!integerMap.containsKey(num)) {
                integerMap.putIfAbsent(num, index++);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int num : arr) {
            builder.append(integerMap.get(num)).append(" ");
        }

        System.out.println(builder);
    }
}
