package examples.chap05;

import examples.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    public static void main(String[] args) {
        List<Dish> specialMenu = List.of(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );
        // 매핑
        // map 메서드는 스트림의 각 요소에 함수를 적용한 결과로 이루어진 새로운 스트림을 반환한다.
        List<String> dishNames = specialMenu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(dishNames);

        List<String> words = List.of("Modren", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(wordLengths);

        List<Integer> dishNameLengths = specialMenu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(dishNameLengths);

        // 스트림 평면화
        // 스트림의 각 값을 다른 스트림으로 만들고 모든 스트림을 하나의 스트림으로 연결하는 기능
        // map 과 flatMap 의 차이점은 flatMap 은 스트림의 각 값을 다른 스트림으로 만든 다음 모든 스트림을 하나의 스트림으로 연결한다.
        words = List.of("Hello", "World");
        List<String[]> strings = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        strings.forEach(strs -> System.out.println(Arrays.toString(strs)));

        List<String> strings1 = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(strings1);

        // 퀴즈 1 각 숫자의 제곱근으로 이루어진 리스트를 반환하시오
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
        List<Integer> squares = numbers1.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(squares);
        // 퀴즈 2 두 개의 숫자 리스트가 있을 때 모든 숫자 쌍의 리스트를 반환하시오.
        List<Integer> numbers2 = List.of(1, 2, 3);
        List<Integer> numbers3 = List.of(3, 4);
        List<int[]> pairs = numbers2.stream()
                .flatMap(i -> numbers3.stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));

        // 퀴즈 3 합이 3으로 나누어 떨어지는 쌍만 반환하시오.
        pairs = numbers2.stream()
                .flatMap(i -> numbers3.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));
    }
}
