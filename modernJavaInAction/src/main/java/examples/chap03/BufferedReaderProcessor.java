package examples.chap03;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
    /*
    * 함수형 인터페이스의 추상 메서드 시그니처를 함수 디스크립터 라고 부른다.
    * */
    String process(BufferedReader b) throws IOException;
}
