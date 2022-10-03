package examples.chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApple {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        /*
        * 녹색 사과 리스트를 반환하려할때 Java 8과 이전 버전 비교
        * */

        // 자바 8 이전
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApplesByJava8Prev = filteringGreenApple(inventory);
        System.out.println(greenApplesByJava8Prev);

        // 자바 8 익명함수를 사용 - 한번만 사용이 필요한 코드의 경우 익명함수를 사용
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApplesByAnonymous = filteringGreenApple(inventory, apple -> "green".equals(apple.getColor()));
        System.out.println(greenApplesByAnonymous);

        // 자바 8 메소드 참조를 사용 - 람다가 몇 줄 이상으로 길어진다면 메소드로 추출하여 메소드 참조를 사용
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApplesByMethodReference = filteringGreenApple(inventory, FilteringApple::isGreenApple);
        System.out.println(greenApplesByMethodReference);
    }

    public static List<Apple> filteringGreenApple(List<Apple> inventory) {
        List<Apple> greenApples = new ArrayList<>();

        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                greenApples.add(apple);
            }
        }

        return greenApples;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }
    public static List<Apple> filteringGreenApple(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> greenApples = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                greenApples.add(apple);
            }
        }

        return greenApples;
    }

    public static class Apple {

        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }

    }
}
