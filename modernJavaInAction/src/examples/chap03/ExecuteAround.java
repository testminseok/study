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
