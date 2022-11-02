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

        /*
        * filter, map, limit, sorted, distinct 등은 중간연산에 해당된다.
        * forEach(void), count(long), collect 는 최종연산에 해당된다.
        * 중간연산으로 파이프라인을 구성할 수 있지만, 중간 연산만으로는 어떤 결과도 도출 할 수 없다. (최종연산이 없으면 아무연산하지 않음)
        * */
        List<String> names =
                menu.stream()
                        /*
                        * filter 와 map 은 서로 다른 연산이지만 한 과정으로 병합되었는데 이 기법을 루프 퓨전이라고 한다.
                        * */
                        .filter(dish -> {
                            System.out.println("filtering : " + dish.getName());
                            return dish.getCalories() > 300;
                        })
                        .map(dish -> {
                            System.out.println("mapping : " + dish.getName());
                            return dish.getName();
                        })
                        /*
                        * 300 칼로리가 넘는 요리는 여러 개지만 오직 처음 3개만 선택되었는데,
                        * 이는 limit 연산과 쇼트서킷이라 불리는 기법덕분이다.
                        * */
                        .limit(3)
                        .collect(Collectors.toList());
        System.out.println(names);
    }
}
