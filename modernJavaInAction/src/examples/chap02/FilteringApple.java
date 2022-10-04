package examples.chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


enum Color {
    GREEN,
    RED
}

public class FilteringApple {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        /*
         * 변화 하는 요구사항에 대응하는 코드 작성
         * */

        // 상황 1 녹색사과만 추출해주세요.
        List<Apple> greenApples = greenApples(inventory);
        System.out.println(greenApples);

        // 상황 2 무게가 150 이상인것만 추출해주세요
        List<Apple> heavyApples = heavyApples(inventory);
        System.out.println(heavyApples);

        /*
        * 위 상황처럼 요구사항이 늘어날때 마다 작성해야하는 코드가 계속 생겨난다.
        * 때문에 전략 디자인패턴을 사용하여 캡슐화 한다.
        * filteringApples 메서드 내부에서 컬렉션을 반복하는 로직과 컬렉션의 각 요소에 적용할 동작을
        * 분리할 수 있다는 점에서 소프트웨어 엔지니어링적으로 큰 이득을 얻는다.
        * */
        List<Apple> greenApples2 = filteringApples(inventory, new AppleGreenColorPredicate());
        System.out.println(greenApples2);

        List<Apple> heavyApples2 = filteringApples(inventory, new AppleHeavyWeightPredicate());
        System.out.println(heavyApples2);
    }

    public static List<Apple> filteringApples(List<Apple> apples, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> greenApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (Color.GREEN == apple.getColor()) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> heavyApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (150 < apple.getWeight()) {
                result.add(apple);
            }
        }

        return result;
    }

    public static class Apple {

        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }

    }
}
