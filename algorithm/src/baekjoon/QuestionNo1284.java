package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class QuestionNo1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while (!(str = inputStreamReader.readLine()).equals("0")) {
            int length = str.length();
            int width = length + 1; // 양 끝 너비와, 숫자 사이 너비
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt == '0') {
                    width += 4;
                } else if (charAt == '1') {
                    width += 2;
                } else {
                    width += 3;
                }
            }
            stringBuilder.append(width).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
