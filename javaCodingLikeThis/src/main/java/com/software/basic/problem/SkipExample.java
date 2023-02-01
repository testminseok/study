package com.software.basic.problem;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;

/**
 * 1-16 실수하기 쉬운 skip 메소드
 * - skip 메소드는 대부분 정상적으로 작동하지만 다양한 이유로 입력한 길이보다 작은 길이만 건너뛰는 현상이 발생한다.
 * - CheckSkipResult : skip 메소드를 사용할 때 실제 얼마만큼 건너뛰었는지 확인하지 않으면 경고하고 수정하기를 권한다.
 */
public class SkipExample {
    private static final String DEFAULT_FILE_PATH = "D:" + File.separator + "text.txt";

    public static void main(String[] args) {
        badCode();
        goodCode();
    }

    /*
    * 최적의 방안은 skip 메소드가 어떤 예외에도 원하는 범위만큼 건너뛰어 주는것이지만 아직 불가능한 일이다.
    * 차선책으로 skip 메소드를 사용할 떄 얼마만큼 건너뛰었는지 결과를 확인하고
    * 원하는 범위에 도달할때 까지 skip 메소드를 다시 실행하는 방법을 써야한다.
    * */
    private static void goodCode() {
        try (FileInputStream is = new FileInputStream(DEFAULT_FILE_PATH)) {
            long skipSize = 1024;
            long skipped;

            // skipSize 만큼 건너뛸 때까지 반복한다.
            while (skipSize != 0) {
                skipped = is.skip(skipSize);
                if (skipped == 0) {
                    throw new EOFException();
                }
                skipSize -= skipped;
            }

            int i;
            StringBuilder sb = new StringBuilder();
            while ((i = is.read()) != -1) {
                sb.append((char) i);
            }
            System.out.println(sb.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void badCode() {
        try (FileInputStream is = new FileInputStream(DEFAULT_FILE_PATH)) {
            // 1024 바이트만큼 건너뛴다.
            is.skip(1024);

            int i;
            StringBuilder sb = new StringBuilder();
            while ((i = is.read()) != -1) {
                sb.append((char) i);
            }

            System.out.println(sb.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
