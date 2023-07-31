package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo10831 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");

        int size = Integer.parseInt(stringTokenizer.nextToken());
        int[] buckets = new int[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = i + 1;
        }

        int shuffleCount = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < shuffleCount; i++) {
            stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
            int bucketIdx1 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int bucketIdx2 = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            int temp = buckets[bucketIdx1];
            buckets[bucketIdx1] = buckets[bucketIdx2];
            buckets[bucketIdx2] = temp;
        }

        StringBuilder builder = new StringBuilder();
        for (int boll : buckets) {
            builder.append(boll).append(" ");
        }
        System.out.println(builder);
    }
}
