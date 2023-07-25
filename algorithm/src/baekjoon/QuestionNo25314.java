package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int byteCount = Integer.parseInt(inputStreamReader.readLine());
        int count = byteCount/4;
        int reminder = byteCount % 4;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append("long ");
        }

        if (reminder != 0) {
            result.append("long ");
        }

        result.append("int");

        System.out.println(result);
    }
}
