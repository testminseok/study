package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while (!(str = inputStreamReader.readLine()).equals("#")) {
            int vowelCnt = getVowelCnt(str);
            stringBuilder.append(vowelCnt).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int getVowelCnt(String str) {
        int vowelCnt = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            String charter = String.valueOf(str.charAt(i));
            if (charter.equalsIgnoreCase("a") ||
                    charter.equalsIgnoreCase("e") ||
                    charter.equalsIgnoreCase("i")||
                    charter.equalsIgnoreCase("o") ||
                    charter.equalsIgnoreCase("u")) {
                vowelCnt++;
            }
        }
        return vowelCnt;
    }
}
