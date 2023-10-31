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
                minValue = Integer.min(minValue,
                        Integer.min(calculate("W", arr, i, j), calculate("B", arr, i, j)));
            }
        }

        System.out.println(minValue);
    }

    private static int calculate(String color, String[][] arr, int i , int j) {
        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            // 열의 수정 갯수를 구한다.
            cnt += rowCalculate(color, arr[i + k], j);
            // 시작색깔이 흰색이면 다음 줄은 검은색 부터 시작한다.
            color = color.equals("W") ? "B" : "W";
        }
        return cnt;
    }

    private static int rowCalculate(String color, String[] arr, int j) {
        // 흰색 정상 패턴
        String[] white = new String[]{"W","B","W","B","W","B","W","B"};
        // 검은색 정상 패턴
        String[] black = new String[]{"B","W","B","W","B","W","B","W"};

        int cnt = 0;
        String[] target = color.equals("W") ? white : black;
        for (int i = 0; i < target.length; i++) {
            if (!arr[i + j].equals(target[i])) {
                cnt++;
            }
        }
        return cnt;
    }
}
