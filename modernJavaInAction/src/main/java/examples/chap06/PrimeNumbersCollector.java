package examples.chap06;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static examples.chap06.PartitionPrimeNumbers.isPrime;

public class PrimeNumbersCollector
        implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        /*
        * supplier 는 수집 과정에서 빈 누적자 인스턴스를 만드는 파라미터가 없는 함수다.
        * 두 개의 리스트를 포함하는 맵으로 수집동작을 시작한다.
        * */
        return () -> new HashMap<>() {{
            put(true, new ArrayList<>());
            put(false, new ArrayList<>());
        }};
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (acc, candidate) -> {
            /*
            * 지금까지 발견한 소수 리스트를 isPrime 메소드로 전달한다. (isPrime 의 결과에 따라 소수 리스트와 비소수 리스트를 만든다.)
            * */
            acc.get(isPrime(acc.get(true), candidate))
                    .add(candidate); // isPrime 메소드의 결과에 따라 맵에서 알맞은 리스트를 받아 현재 candidate 값을 추가한다.
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        /*
        * 알고리즘 자체가 순차적이어서 컬렉터를 실제 병렬로 사용할 순 없다. 따라서 combiner 메소드는
        * 호출될 일이 없으므로 빈구현으로 남겨둘 수 있다. (또는 UnsupportedOperationException 을 던지는것도 좋은 방법이다.)
        * */
        return (map1, map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity(); // 최종 수집과정에서 데이터 변환이 필요하지 않으므로 항등함수 반환
    }

    @Override
    public Set<Characteristics> characteristics() {
        /*
        * 발견한 소수의 순서에 의미가 있으므로 컬렉너는 IDENTITY_FINISH 이지만 UNORDERED, CONCURRENT 는 아니다.
        * */
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }
}
