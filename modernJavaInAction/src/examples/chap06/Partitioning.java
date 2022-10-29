package examples.chap06;

import examples.chap04.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Partitioning {
    public static void main(String[] args) {
        // partitioningBy - 채식인 요리만 분류
        Map<Boolean, List<Dish>> partitioningByVegetarianMenu = Dish.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitioningByVegetarianMenu.get(true));

        // filter 로 동일한 결과 추출
        List<Dish> filteringByVegetarianMenu = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        System.out.println(filteringByVegetarianMenu);

        // 채식요리와 그렇지 않은것을 Dish.Type 으로 분류
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = Dish.menu.stream()
                .collect(
                        partitioningBy(
                                Dish::isVegetarian, // 분할 함수
                                groupingBy(Dish::getType) // 두번째 컬렉터
                        ));
        System.out.println(vegetarianDishesByType);

        // 채식요리와 그렇지 않은것 중에 각각 칼로리가 가장 높은 음식 하나
        Map<Boolean, Dish> mostCaloricPartitioningByVegetarian = Dish.menu.stream()
                .collect(
                        partitioningBy(
                                Dish::isVegetarian,
                                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)
                        ));
        System.out.println(mostCaloricPartitioningByVegetarian);

        // 퀴즈 채식과 그렇지 않은 음식 중 각각 500칼로리가 넘는 음식과 그렇지 않은 음식으로 분할
        Map<Boolean, Map<Boolean, List<Dish>>> vegetarianDishesByHighCaloric = Dish.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, partitioningBy(dish -> dish.getCalories() > 500)));
        System.out.println(vegetarianDishesByHighCaloric);

        // 채식음식과 그렇지 않은 음식의 수 구하기
        Map<Boolean, Long> vegetarianDishesByCount = Dish.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, counting()));
        System.out.println(vegetarianDishesByCount);

        // 소수와 비소수로 분할하기
        Map<Boolean, List<Integer>> collect = IntStream.range(2, 10).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
        System.out.println(collect);
    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate); // 소수의 대상을 주어진 수의 제곱근 이하로 제한한다.
        return IntStream.range(2, candidateRoot) // 2부터 candidate 미만 사이의 자연수 생성
                .noneMatch(i -> candidate % i == 0); // 스트림의 모든 정수로 candidate 를 나눌 수 없으면 반환한다.
    }
}
