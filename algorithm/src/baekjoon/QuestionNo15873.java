package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo15873 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String str = inputStreamReader.readLine();
        int length = str.length();

        if (length >= 3) {
            String substring = str.substring(length - 2, length - 1);

            // 끝에서 2번째 자리가 0인경우 B 는 10이 아닌 양수로 끝자리를 제외한 나머지 수가 A
            if (substring.equals("0")) {
                int A = Integer.parseInt(str.substring(0, length - 1));
                int B = Integer.parseInt(str.substring(length - 1));
                System.out.println(A + B);
            }

            // 끝자리가 0 인경우 B 는 10으로, 끝 2자리를 제외한 나머지 수가 A
            if (str.substring(length - 1).equals("0")) {
                int A = Integer.parseInt(str.substring(0, length - 2));
                int B = 10;
                System.out.println(A + B);
            }

        } else {
            String[] split = str.split("");
            int A = Integer.parseInt(split[0]);
            int B = Integer.parseInt(split[1]);
            System.out.println(A + B);
        }

    }
}
