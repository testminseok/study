package examples.chap10;

import java.util.List;
import java.util.function.Consumer;

public class PrintNumbers {
    public static void main(String[] args) {
        List<String> numbers = List.of("one", "two", "three");
        numbers.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // 람다 표현식으로 변경
        numbers.forEach((s) -> System.out.println(s));

        // 메소드 참조
        numbers.forEach(System.out::println);
    }
}
