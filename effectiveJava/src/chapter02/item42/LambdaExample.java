package chapter02.item42;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        // Generic 이 있으므로 컴파일러가 타입추론을 할 수 있다.
        List<String> word = List.of("abcdefg", "bcdefg", "cdefg", "defg", "efg", "fg", "g");

        // 익명 클래스의 인스턴스를 함수 객체로 사용 - 낡은 기법이다.
        Collections.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        // 람다식을 함수 객체로 사용 - 익명 클래스 대체
        Collections.sort(word, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

        // 람다식을 함수 객체로 사용 - Comparator.comparingInt 메서드 사용
        Collections.sort(word, Comparator.comparingInt(String::length));

        // 람다식을 함수 객체로 사용 - List.sort 메서드 사용
        word.sort(Comparator.comparingInt(String::length));
    }
}
