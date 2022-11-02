package examples.chap06;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/*
 * 순차 리듀싱 과정의 논리적 순서
 * 시작
 * A accumulator = collector.supplier().get();
 * while (스트림에 요소가 남아있는가) {
 *   T next = 스트림의 다음학목을 가져옴
 *   collector.accumulator().accept(accumulator, next)
 * }
 * R result = collector.finisher().apply(accumulator)
 * return result
 * */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    @Override
    public Supplier<List<T>> supplier() {
        /*
         * supplier - 새로운 결과 컨테이너 만들기
         * supplier 는 수집 과정에서 빈 누적자 인스턴스를 만드는 파라미터가 없는 함수다.
         * */
//        return () -> new ArrayList<T>();
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        /*
         * accumulator - 결과 컨테이너에 요소 추가하기
         * 리듀싱 연산을 수행하는 함수를 반환한다.
         * accumulator 가 반환하는 함수는 이미 탐색한 항목을 포함하는 리스트에 현재 항목을 추가하는 연산을 수행한다.
         * */
//        return (list, item) -> list.add(item);
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        /*
        * combiner - 두 결과 컨테이너 병합
        * combiner 는 스트림의 서로 다른 서브파트를 병렬로 처리할때 누적자가 이 결과를 어떻게 처리할지를 정의한다.
        * toList 를 구현할때는 둘이 합치면 된다.
        * */
        return (list, list2) -> {
            list.addAll(list2);
            return list;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        /*
         * finisher - 최종 변환값을 결과 컨테이너로 적용하기
         * 누적자가 최종 결과인 상황에서는 변환 과정이 필요하지 않으므로 finisher 메소드는 항등 함수를 반환한다.
         * */
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        /*
        * characteristics 는 컬렉터의 연산을 정의하는 Characteristics 형식의 불변 집합을 반환한다.
        * Characteristics 는 스트림을 병렬로 리듀스할 것인지 그리고 병렬로 리듀스 한다면 어떤 최적화를 선택해야 할지 힌트를 제공한다.
        * Characteristics
        *   UNORDERED : 리듀싱 결과는 스트림 요소의 방문 순서나 누적 순서에 영향을 받지 않는다.
        *   CONCURRENT : 다중 스레드에서 accumulator 함수를 동시에 호출할 수 있으며 이 컬렉터는 스트림의 병렬 리듀싱을 수행 할 수 있다.
        *                컬렉터의 플래그에 UNORDERED 를 함께 설정하지 않았다면 데이터 소스가 정렬되어 있지 않은 상황에서만
        *                병렬 리듀싱을 수행할 수 있다.
        *   IDENTITY_FINISH : finisher 메소드가 반환하는 함수는 단수히 identity 를 적용할 뿐이므로 이를 생략할 수 있다.
        *                     따라서 리듀싱 과정의 최종 결과로 누적자 객체를 바로 사용할 수 있다,
        *                     또한 누적자 A를 결과 R 로 안전하게 형변환 할 수 있다.
        *
        * toListCollector 에서 스트림의 요소를 누적하는 데 사용한 리스트가 최종 결과 형식이므로 변환이 필요없다.
        * 따라서 IDENTITY_FINISH 이다. 순서도 상관 없으므로 UNORDERED 이다.
        * 요소의 순서가 무의미한 데이터 소스여야 병렬로 실행할 수 있다.
        * */
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}
