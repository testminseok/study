package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        String[][] arr = new String[N][M];
        for (int i = 0; i < N; i++) {
            String[] strings = inputStreamReader.readLine().split("");
            System.arraycopy(strings, 0, arr[i], 0, M);
        }



        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                // 시작 색깔이 흰색인경우, 검은색인경우 둘다 구해 최소값 설정
                minValue = Integer.min(cal("W", minValue, arr, i, j), cal("B", minValue, arr, i, j));
            }
        }

        System.out.println(minValue);
    }

    private static int cal(String color, int minValue, String[][] arr, int i , int j) {
        // 흰색 정상 패턴
        String[] white = new String[]{"W","B","W","B","W","B","W","B"};
        // 검은색 정상 패턴
        String[] black = new String[]{"B","W","B","W","B","W","B","W"};
        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            if (color.equals("W")) {
                for (int z = 0; z < 8; z++) {
                    // 가로세로 비교하여 흰색 정상 패턴과 다른 갯수를 구한다.
                    if (!arr[i + k][j + z].equals(white[z])) {
                        cnt++;
                    }
                }
                // 흰색의 다음 줄은 검은색이여야 함
                color = "B";
            } else {
                for (int z = 0; z < 8; z++) {
                    // 가로세로 비교하여 검은색 정상 패턴과 다른 갯수를 구한다.
                    if (!arr[i + k][j + z].equals(black[z])) {
                        cnt++;
                    }
                }
                // 검은색의 다음 줄은 흰색이여야 함
                color = "W";
            }
        }
        return Integer.min(minValue, cnt);
    }
}
