package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo5532 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(inputStreamReader.readLine()); // 방학기간
        int A = Integer.parseInt(inputStreamReader.readLine()); // 국어 총 페이지 수
        int B = Integer.parseInt(inputStreamReader.readLine()); // 수학 총 페이지 수
        int C = Integer.parseInt(inputStreamReader.readLine()); // 하루 최대 풀 수 있는 국어 페이지 수
        int D = Integer.parseInt(inputStreamReader.readLine()); // 하루 최대 풀 수 있는 수학 페이지 수

        int day = 0;
        int koreanPage = 0;
        int methPage = 0;
        do {
            day++;
            koreanPage += C;
            methPage += D;
        } while (A > koreanPage || B > methPage);

        System.out.println(L - day);
    }
}
