package examples.chap09;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Peek {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        numbers.stream()
                .map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);

        numbers.stream()
                .peek(x -> System.out.println("from stream : " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after stream : " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after stream : " + x))
                .limit(3)
                .peek(x -> System.out.println("after stream : " + x))
                .collect(Collectors.toList());
    }
}
