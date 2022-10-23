package examples.chap05;

import examples.chap04.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {
    public static void main(String[] args) {
        // 총 칼로리
        int totalCalories = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(totalCalories);

        // 기본형 특화 스트림
        // ex) Integer, Long 등등 기본자료형의 경우 기본형(int, long)으로 언박싱하는 비용이 있다.
        int totalCalories2 = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(totalCalories2);

        // IntStream 을 반환하는게 아닌 Stream<Integer> 를 반환한다.
        Stream<Integer> boxed = Dish.menu.stream()
                .mapToInt(Dish::getCalories) // IntStream
                .boxed();

        // 값이 없었을 때 기본 최대값을 명시적으로 설정할 수 있다.
        OptionalInt maxCalories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println(maxCalories.orElse(1)); // 값이 없었을때 기본 최대값을 1로 몇시적으로 설정

        // 값의 범위를 이용해야할 때에는 range() 와 rangeClosed
        // range 는 첫번째와 마지막 값은 결과에 포함시키지 않는 반면 rangeClosed 는 포함시킨다는 차이점이있다.
        long rangeClosedCount = IntStream.rangeClosed(1, 100) // 1 부터 100까지의 범위를 나타낸다.
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println(rangeClosedCount); // 50

        long rangeCount = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println(rangeCount); // 49

        // 피타고라스 수
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );



        pythagoreanTriples.limit(5)
                .forEach(t -> System.out.printf("%d, %d, %d \n", t[0], t[1], t[2]));

        // 개선된 피타고라스 수
        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0)
                );
        pythagoreanTriples2.limit(5)
                .forEach(t -> System.out.printf("%f, %f, %f \n", t[0], t[1], t[2]));
    }
}
