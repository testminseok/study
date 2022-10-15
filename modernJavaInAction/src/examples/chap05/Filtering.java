package examples.chap05;

import examples.chap04.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class Filtering {
    public static void main(String[] args) {
        // Predicate 로 filtering
        List<Dish> vegetarianMenu =
                Dish.menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(Collectors.toList());

        // 고유 요소 필터링
        List<Integer> numbers = List.of(1, 2, 1, 3, 3, 2, 4);
        /*
        * distinct 메서드의 고유 여부는 스트림에서 만든 객체의 hashCode 와 equals 메서드로 판단한다.
        * */
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // 스트림 슬라이싱
        List<Dish> specialMenu = List.of(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );

        // 320 칼로리 이하의 음식 선택
        specialMenu.stream()
                .filter(d -> d.getCalories() < 320)
                .collect(Collectors.toList());

        // 이미 정렬되어있는 경우에 320칼로리보다 크거나 같은요리가 나왔을 때 takeWhile 을 사용하여 반복작업을 중단할 수 있다.
        specialMenu.stream()
                .takeWhile(d -> d.getCalories() < 320)
                .collect(Collectors.toList());

        // dropWhile 은 takeWhile 의 반대로 320칼로리보다 크거나 같은 음식이 나올 때까지 건너뛴다.
        specialMenu.stream()
                .dropWhile(d -> d.getCalories() < 320)
                .collect(Collectors.toList());

        // 스트림 축소
        // 정렬되지 않은 스트림에도 limit 메서드를 사용할 수 있다.
        // 소스가 정렬되어 있지 않았다면 limit 의 결과도 정렬되지 않은 상태로 반환된다.
        specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());

    }
}
