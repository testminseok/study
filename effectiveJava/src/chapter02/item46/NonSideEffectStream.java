package chapter02.item46;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/*
* 스트림 파이프라인 프로그래밍의 핵심은 부작용 없는 함수 객체에 있다. 스트림뿐 아니라
* 스트림 관련 객체에 건네지는 모든 함수 객체가 부작용이 없어야 한다. 종단 연산 중 forEach 는 스트림이 수행한
* 계산 결과를 보고할 때만 이용해야 한다. 계산 자체에는 이용하지 말자. 스트림을 올바로 사용하려면 수집기를 잘 알아둬야 한다.
* 가장 중요한 수집기 팩터리는 toList, toSet, toMap, groupingBy, joining 이다.
* */
public class NonSideEffectStream {
    public static void main(String[] args) {
        Map<String, Long> freq = Map.of("a", 1L, "b", 2L, "c", 3L, "d", 4L, "e", 5L);
        try (Stream<String> words = new Scanner(System.in).tokens()){
//            words.forEach(word -> freq.merge(word.toLowerCase(), 1L, Long::sum)); // Stream API의 장점을 전혀 살리지 못했다.
            // 스트림을 제대로 활용해 빈도표를 초기화 한다.
            freq = words.collect(groupingBy(String::toLowerCase, counting()));

            // 빈도표에서 가장 흔한 단어 10개를 뽑아내는 파이프라인
            List<String> topTen = freq.keySet().stream()
                    .sorted(comparing(freq::get).reversed())
                    .limit(10)
                    .collect(toList());
        }
    }
}
