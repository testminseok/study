package examples.chap05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {
    public static void main(String[] args) {
        // Stream.of
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase)
                .forEach(System.out::println);

        // Stream.empty
        Stream<String> empty = Stream.empty();

        // 자바 9이전에 값이 null 일 경우 명시적으로 확인 해야했다.
        String homeValue = System.getProperty("home"); // return null
        Stream<String> homeValueStream =
                homeValue == null ? Stream.empty() : Stream.of(homeValue);

        // 자바 9에 ofNullable 메소드가 되어 값이 null 일경우 Stream.empty 를 반환한다.
        Stream<String> homeValueStream2
                = Stream.ofNullable(homeValue);

        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        // Arrays.stream (배열로 스트림만들기)
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        // File 로 스트림만들기
        long uniqueWords = 0;
        // Stream 은 AutoCloseable 을 구현했기 때문에 try-catch-resource 를 사용하여 close() 를 호출한다.
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))) // 고유 단어 수 계산
                    .distinct() // 중복제거
                    .count(); // 단어 스트림 생성
        } catch (IOException e) {
            System.out.println("Files IOE !!!");
        }

        /*
        * 무한 스트림, 즉 고정된 컬렉션에서 고정된 크기로 스트림을 만들었던 것과는 달리 크기가 고정되어 있지 않은 스트림을 만들 수 있다.
        * 그러나 모통 무한한 값을 출력하지 않도록 limit(n) 함수를 함께 연결하여 사용한다.
        * */
        // Stream.iterate
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // 퀴즈 - iterate 를 사용하여 피보나치수열 집합 20개 생성
        Stream.iterate(new int[]{0, 1}, array -> new int[] {array[1], array[0] + array[1]})
                .limit(20)
                .forEach(t -> System.out.printf("(%d,%d) \n", t[0], t[1]));

        // 피보나치 수열
        Stream.iterate(new int[]{0, 1}, array -> new int[] {array[1], array[0] + array[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        // Stream.generate
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        // Bad Code - 발행자에 상태가 있으면 병렬코드에서는 안전하지 않다.
        IntStream.generate(new IntSupplier() {
            private int prev = 0;
            private int curr = 1;

            @Override
            public int getAsInt() {
                int oldPrev = this.prev;
                int nextVal = this.prev + this.curr;
                this.prev = this.curr;
                this.curr = nextVal;
                return oldPrev;
            }
        }).limit(10).forEach(System.out::println);

    }
}
