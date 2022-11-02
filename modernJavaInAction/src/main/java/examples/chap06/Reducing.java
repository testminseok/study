package examples.chap06;

import examples.chap04.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reducing {
    public static void main(String[] args) {
        // reducing (총합 칼로리 구하기)
        int totalCalories = Dish.menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(totalCalories);
        
        // 칼로리가 가장 높은 음식 찾기
        Dish.menu.stream()
                .collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2))
                .ifPresent(System.out::println);

        // reduce 를 사용하여 collect(Collectors.toList()) 구현하기
        // 그러나 collect 메소드는 도출하려는 결과를 누적하는 컨테이너를 바꾸도록 설계된 반면
        // reduce 는 두 값을 하나로 도출하는 불변형 연산이라는 점에서 의미론적인 문제가 일어난다.
        // 또한 성능이 저하를 야기할 수 있다.
        List<Integer> reduceToList = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(
                        new ArrayList<Integer>(),
                        (List<Integer> list, Integer element) -> {
                            list.add(element);
                            return list;
                        },
                        (List<Integer> list, List<Integer> list2) -> {
                            list.addAll(list2);
                            return list;
                        }
                );
        System.out.println(reduceToList);

        int totalCalories2 = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum).get();
        System.out.println(totalCalories2);

        int totalCalories3 = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(totalCalories3);

        Dish.menu.stream().map(Dish::getName).collect(Collectors.joining());
    }
}
