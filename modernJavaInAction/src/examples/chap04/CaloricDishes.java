package examples.chap04;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CaloricDishes {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        // 자바 7의 경우
        // 저칼로리의 요리명을 반환하고, 칼로리를 기준으로 요리를 정렬한다.
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }

        System.out.println(lowCaloricDishesName);
        
        // 자바 8 이후 스트림 을 사용함
        lowCaloricDishesName =
                menu.stream() // 메뉴에서 스트림을 얻는다.
                        .filter(dish -> dish.getCalories() < 400) // 400 칼로리 이하의 요리를 선택
                        .sorted(Comparator.comparingInt(Dish::getCalories)) // 칼로리를 기준으로 정렬
                        .map(Dish::getName) // 요리명 추출
                        .collect(Collectors.toList()); // 요리명을 리스트로 저장

        System.out.println(lowCaloricDishesName);

        // 고칼로리 음식을 3개 찾아서 이름을 반환
        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames);
    }
}
