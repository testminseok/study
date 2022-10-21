package examples.chap05;

import examples.chap04.Dish;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Reducing {
    public static void main(String[] args) {
        // 리듀싱 연산이란 모든 스트림의 요소를 처리해서 값으로 도출하는 작업이다.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);

        sum = 0;
        for (int number : numbers) {
            sum *= number;
        }
        System.out.println(sum);

        // reduce 의 첫번째 매개변수는 초기값을 설정한다. ex) 0
        // a 는 누적치의 값이 설정된다. 최초는 초기값과 동일
        // b 는 다음 스트림을 소비하여 값이 설정된다.
        sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        sum = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(sum);

        sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        /*
        * 초기값을 받지 않도록 선언되어있는 메소드도 있지만,
        * 스트림에 아무요소도 없을 상황에 null 를 반환할 수 있도록 Optional 을 반환한다.
        * */
        Optional<Integer> optionalInteger =
                numbers.stream().reduce((a, b) -> a + b);

        Optional<Integer> maxNumber =
                numbers.stream().reduce(Integer::max);

        Optional<Integer> minNumber =
                numbers.stream().reduce(Integer::min);

        // 퀴즈 - map 과 reduce 메소드를 이용해서 스트림의 요리개수를 구하기
        // map 과 reduce 를 연결하는 기법을 맵 리듀스패턴이라고 한다.
        // 쉽게 병렬화 할 수 있는 특징이 있다.
        int reduce = Dish.menu.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
        System.out.println(Dish.menu.size());

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
        Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .boxed();

        // 값이 없었을 때 기본 최대값을 몇시적으로 설정할 수 있다.
        OptionalInt maxCalories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

    }
}