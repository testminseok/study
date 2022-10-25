package examples.chap06;

import examples.chap04.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

public class Summarizing {
    public static void main(String[] args) {

        // counting
        long howManyDishes = Dish.menu.stream().collect(Collectors.counting());
        System.out.println(howManyDishes);

        // count 로 동일한 결과를 도출
        long dishesCount = Dish.menu.stream().count();
        System.out.println(dishesCount);

        // maxBy - 가장 큰 값을 구한다.
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Dish.menu.stream()
                .collect(Collectors.maxBy(dishComparator))
                .ifPresent(System.out::println);

        // summingInt - 합계를 구한다.
        int totalCalories = Dish.menu.stream()
                .collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        // averagingInt - 평균값을 구한다.
        double average = Dish.menu.stream()
                .collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(average);

        // summarizingInt - 요소 수, 합계, 평균, 최대값, 최솟값 계산
        IntSummaryStatistics summaryStatistics = Dish.menu.stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getCount());

        // joining - 문자열은 연결한다
        String joining = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining());
        System.out.println(joining);

        String joiningByDelimiter = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(", "));
        System.out.println(joiningByDelimiter);
    }
}
