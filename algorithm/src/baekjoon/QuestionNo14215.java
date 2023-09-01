package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuestionNo14215 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);

        while (arr[arr.length - 1] >= arr[0] + arr[1]) {
            arr[arr.length - 1]--;
        }

        System.out.println(arr[0] + arr[1] + arr[2]);
    }
}
