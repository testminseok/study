package examples.chap03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.io.File.separator;

public class ExecuteAround {
    private static final String FILENAME = "D:" + separator + "modernJavaInAction" + separator + "data.txt";

    public static void main(String[] args) throws IOException {
        // 자바 8 이전
        // 익명클래스
        String result = processFile(new BufferedReaderProcessor() {
            @Override
            public String process(BufferedReader b) throws IOException {
                return b.readLine();
            }
        });

        System.out.println(result);

        /*
         * 람다 표현식의 형식의 검사 과정
         * 1. 대상형식(메소드 파라미터나 람다가 할당되는 변수)을 확인한다.
         *      - Object o = () -> System.out.println("Hello World"); 에서 o의 대상형식은 Object 이다.
         * 2. 람다가 할당되는 변수 즉 함수형 인터페이스의 추상메서드를 확인한다.
         * 3. 함수 디스크립터와 람다의 시그니처를 비교하여 일치하는지 확인한다.
         * */
        // 자바 8 이후 람다
        String result2 = processFile((BufferedReader b) -> b.readLine());
        System.out.println(result2);
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            return p.process(br);
        }
    }
}
