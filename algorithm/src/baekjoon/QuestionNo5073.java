package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuestionNo5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String str;
        while ((str = inputStreamReader.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int[] arr = new int[]{a, b, c};
            Arrays.sort(arr);
            if (arr[arr.length - 1] >= arr[0] + arr[1]) {
                builder.append("Invalid").append("\n");
            } else if (a == b && b == c) {
                builder.append("Equilateral").append("\n");
            } else if (a == b || b == c || a == c) {
                builder.append("Isosceles").append("\n");
            } else {
                builder.append("Scalene").append("\n");
            }
        }

        System.out.println(builder);
    }
}
