package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            // M 보다 큰 숫자의 카드는 선택 불가
            if (num >= M) continue;
            nums[i] = num;
        }

        int result = 0;
        find:
        // 첫번째 카드
        for (int i = 0; i < nums.length - 2; i++) {
            int num1 = nums[i];

            // 두번째 카드 - 중복 선택 하지 않기 위해 첫번재 다음 번 부터 시작
            for (int j = i + 1; j < nums.length - 1; j++) {
                int num2 = nums[j];

                // 첫번째 카드와 두번째 카드가 M 보다 크거나 같으면 그 카드는 선택 불가
                if (num1 + num2 >= M) {
                    continue;
                }

                // 세번째 카드 - 중복 선택 하지 않기 위해 두번재 다음 번 부터 시작
                for (int k = j + 1; k < nums.length; k++) {
                    int num3 = nums[k];
                    int myNum = num1 + num2 + num3;

                    if (myNum == M) {
                        result = myNum;
                        break find;
                    }

                    // M 과 최대한 가까운 수 로 갱신
                    if (myNum > result && myNum < M) {
                        result = myNum;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
