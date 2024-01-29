package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo23825 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
        int S = Integer.parseInt(stringTokenizer.nextToken());
        int A = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(Integer.min(S, A) / 2);
    }
}
