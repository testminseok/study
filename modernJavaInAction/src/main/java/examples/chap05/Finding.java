package examples.chap05;

import examples.chap04.Dish;

import java.util.List;
import java.util.Optional;

public class Finding {
    public static void main(String[] args) {
        /*
        * 쇼트서킷 기법
        * - 모든 원소를 처리하지 않고도 결과를 반환할 수 있다.
        * - 원하는 요소를 찾았으면 즉시 결과를 반환할 수 있다.
        * - 무한한 요소를 가진 스트림을 유한한 크기로 줄일 수 있는 유용한 연산이다.
        * ex) allMatch, noneMatch, findFirst, findAny, limit 등
        * */
        // 적어도 한 요소와 일치하는지 확인할때 anyMatch
        if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        // 모든 요소가 주어진 Predicate 와 일치하는지 확인할때 allMatch
        if (Dish.menu.stream().allMatch(dish -> dish.getCalories() < 1000)) {
            System.out.println("this foods is healthy");
        }

        // allMatch 와 반대인 noneMatch 주어진 Predicate 와 일치하는 요소가 없는지 확인
        if (Dish.menu.stream().noneMatch(dish -> dish.getCalories() >= 1000)) {
            System.out.println("this foods is healthy");
        }

        // 쇼트서킷을 이용해서 결과를 찾는 즉시 종료한다.
        /*
        * findFirst 와 findAny
        * 병렬 실행에서는 첫 번째 요소를 찾기 어렵다. 따라사ㅓ 요소의 반환 순서가 상관이 없다면 병렬 스트림에서는
        * 제약이 적은 findAny 를 사용한다.
        * */
        Optional<Dish> dish = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .map(Dish::getName)
                .ifPresent(System.out::println); // 요소가 존재한다면 출력한다.

        List<Integer> someNumbers = List.of(1, 2, 3, 4, 5);
        someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst()
                .ifPresent(System.out::println);

    }
}
