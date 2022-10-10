package examples.chap03;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppleSorting {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        // Comparator 를 상속받는 클래스를 생성해 정렬 기준을 구현
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        Collections.shuffle(inventory); // 사과를 다시 섞는다.

        // 익명 클래스를 사용하여 정렬 기준을 구현
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Integer.compare(o1.getWeight() , o2.getWeight());
            }
        });
        System.out.println(inventory);

        Collections.shuffle(inventory); // 사과를 다시 섞는다.

        // 람다 표현식을 사용하여 정렬 기준을 구현
        // Apple a1, Apple a2 처럼 형식을 지정해주면 자바 컴파일러는 람다 표현식의 형식을 추론하지 않는다.
        // a1, a2 처럼 형식을 지정하지 않으면 자바 컴파일러는 람다 표현식이 사용된 콘텍스트를 활용해서 람다의 형식을 추론한다.
        // 형식을 지정해 주고 안해주고는 개발자에 성향에 따라 구분한다.
        inventory.sort((Apple a1, Apple a2) -> Integer.compare(a1.getWeight() , a2.getWeight()));
        System.out.println(inventory);

        // 메소드 참조를 이용해 더욱 간결하게 표현할 수 있다.
        inventory.sort(
                Comparator.comparingInt(Apple::getWeight) // 메소드 참조를 사용하여 무게를 기준으로 정력
                        .reversed() // 무게를 역순으로 정렬
                        .thenComparing(Apple::getCountry) // 무게가 같을 경우 국가를 기준으로 정렬
        );
    }
}

class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple a1, Apple a2) {
        return Integer.compare(a1.getWeight() , a2.getWeight());
    }
}