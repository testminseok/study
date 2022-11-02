package examples.chap06;

import examples.chap04.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomCollector {
    public static void main(String[] args) {
        List<Dish> collect = Dish.menu.stream()
                .collect(Collectors.toList());
        System.out.println(collect);

        // CustomCollector 만들어서 toList 로 만들기
        List<Dish> myCustomCollector = Dish.menu.stream()
                .collect(new ToListCollector<Dish>());
        System.out.println(myCustomCollector);

        // CustomCollector 만들지 않고 Custom 하기
        List<Dish> customCollector = Dish.menu.stream()
                .collect(ArrayList::new, List::add, List::addAll);
        System.out.println(customCollector);

    }
}
