package chapter02.item37;

import java.util.*;
import java.util.stream.Collectors;

public class Plant {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    public static void main(String[] args) {
        Plant[] garden = {
            new Plant("바질", LifeCycle.ANNUAL),
            new Plant("캐러웨이", LifeCycle.BIENNIAL),
            new Plant("딜", LifeCycle.ANNUAL),
            new Plant("라벤더", LifeCycle.PERENNIAL),
            new Plant("파슬리", LifeCycle.BIENNIAL),
            new Plant("로즈마리", LifeCycle.PERENNIAL)
        };

        badCode(garden);
        goodCode(garden);
        streamCode(garden);
    }

    private static void streamCode(Plant[] garden) {
        EnumMap<LifeCycle, Set<Plant>> plantsByLifeCycle =
                Arrays.stream(garden)
                        .collect(Collectors.groupingBy(p -> p.lifeCycle,
                                () -> new EnumMap<>(LifeCycle.class),
                                Collectors.toSet()));
        System.out.println(plantsByLifeCycle);
    }

    /*
    * EnumMap 을 사용해 데이터와 열거 타입을 매핑한다.
    * 더 짧고 명료하고 안전하고 성능도 비등하다.
    * 맵의 키인 열거 타입이 그 자체로 출력용 문자열을 제공하니 출력 결과에 직접 레이블을 달 일도 없다.
    * 나아가 배열 인덱스를 계산하는 과정에서 오류가 날 가능성도 원천봉쇄된다.
    * */
    private static void goodCode(Plant[] garden) {
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lifeCycle : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lifeCycle, new HashSet<>());
        }

        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }
        System.out.println(plantsByLifeCycle);
    }

    /*
    * ordinal() 을 배열 인덱스로 사용 - 따라 하지 말것!
    * 배열은 제네릭과 호환되지 않으니 비검사 형변환을 수행해야 하고 깔끔히 컴파일 되지 않는다.
    * 배열은 인덱스의 의미를 모르니 출력 결과에 직접 레이블을 달아야한다. 가장 심각한 문제는
    * 정확한 정수값을 사용한다는 것을 여러분이 직접 보증해야 한다는것이다.
    * 정수는 열거 타입과 달리 타입 안전하지 않기 때문이다 잘못된 값을 사용하면 잘못된 동작을 묵묵히 수행하거나
    * 운이 좋다면 ArrayIndexOutOfBoundsException 을 던질 것이다.
    * */
    private static void badCode(Plant[] garden) {
        Set<Plant>[] platsByLifeCycle = (Set<Plant>[]) new Set[LifeCycle.values().length];
        for (int i = 0; i < platsByLifeCycle.length; i++) {
            platsByLifeCycle[i] = new HashSet<>();
        }

        for (Plant p : garden) {
            platsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        for (int i = 0; i < platsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", LifeCycle.values()[i], platsByLifeCycle[i]);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
