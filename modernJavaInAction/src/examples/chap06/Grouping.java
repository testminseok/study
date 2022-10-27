package examples.chap06;

import examples.chap04.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

enum CaloricLevel {
    DIET,
    NORMAL,
    FAT,
}

public class Grouping {
    public static void main(String[] args) {
        // groupingBy
        /*
        * groupingBy(Dish::getType) 에 Dish::getType 을 기준으로 그룹화 되므로 이를 분류함수라고 한다.
        * */
        Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);

        /*
        * 칼로리를 기준으로 400이하는 DIET, 700 이하는 NORMAL, 그 외엔 FAT 으로 분류
        * */
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu.stream()
                .collect(Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }));
        System.out.println(dishesByCaloricLevel);

        /*
        * 500 칼로리 이상의 음식 타입으로 그룹핑 (Collectors.filtering)
        * */
        Map<Dish.Type, List<Dish>> caloricDishesByType = Dish.menu.stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType,
                                Collectors.filtering(
                                        dish -> dish.getCalories() > 500,
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println(caloricDishesByType);

        // 그룹의 각 요리를 관련 이름 목록으로 변환
        Map<Dish.Type, List<String>> dishNamesByType = Dish.menu.stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType,
                                Collectors.mapping(Dish::getName, Collectors.toList())
                        )
                );
        System.out.println(dishNamesByType);
    }
}
