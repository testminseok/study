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
                // 8X8 보드판 생성
                String[][] range = makeBoard(arr, i, j);
                // 시작 색깔이 흰색인경우, 검은색인경우 둘다 구해 최소값 설정
                minValue = Integer.min(minValue, Integer.min(calculate("W", range), calculate("B", range)));
            }
        }

        System.out.println(minValue);
    }

    // 8X8 보드판을 생성한다.
    private static String[][] makeBoard(String[][] arr, int i, int j) {
        String[][] range = new String[8][8];
        for (int k = 0; k < range.length; k++) {
            System.arraycopy(arr[i + k], j, range[k], 0, range[k].length);
        }
        return range;
    }

    // 8X8 의 최소 수정 횟수 을 구한다.
    private static int calculate(String color, String[][] range) {
        int cnt = 0;
        for (String[] rows : range) {
            cnt += rowCalculate(color, rows);
            // 흰색 다음 줄은 검은색 이여야 한다.
            color = color.equals("W") ? "B" : "W";
        }
        return cnt;
    }

    // 한 열의 정상 패턴과 다른 갯수를 구한다.
    private static int rowCalculate(String color, String[] rows) {
        // 흰색 정상 패턴
        String[] white = new String[]{"W","B","W","B","W","B","W","B"};
        // 검은색 정상 패턴
        String[] black = new String[]{"B","W","B","W","B","W","B","W"};
        int cnt = 0;
        String[] target = color.equals("W") ? white : black;
        for (int i = 0; i < target.length; i++) {
            if (!target[i].equals(rows[i])) {
                cnt++;
            }
        }
        return cnt;
    }
}
