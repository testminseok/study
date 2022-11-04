package examples.chap07;

import java.util.function.Function;

public class ParallelStreamsHarness {

    public static void main(String[] args) {
        /*
        * 여러 스레드에서 접근하기 때문에 정확한 값이 나오지 않는다.
        *
        * 병렬 스트림을 선택할때
        * - 확신이 서지 않으면 측정하라. 순차 스트림과 병령 스트림을 벤치마크로 직접 성능을 측정하는 것이 좋다.
        * - 박싱을 주의하라. 자동 박식과 언박싱은 성능을 크게 저하실킬 수 있는 요소다. (되도록이면 기본형 특화 스트림을 사용하는것이 좋다.)
        * - 순차 스트림보다 병렬 스트림에서 성능이 떨어지는 연산이 있다. limit 이나 findFirst 처럼 요소 순서에 의존하는 연산을
        *   병렬 스트림에서 수행하려면 비싼 비용을 치러야한다. ex) findAny 는 findFirst 보다 성능이 좋다.
        *   또한 정렬된 스트림에 unordered 를 호출하면 비정렬된 스트림을 얻을 수 있다. 스트림에 요소 N개가 있을때
        *   요소 순서가 상관이 없다면 비정렬된 스트림에 limit 을 호출하는것이 더 효율적이다.
        * - 스트림에서 수행하는 전체 파이프라인 연산 비용을 고려하라. 처리해야 할 요소가 N 이고 비용을 Q 라고하면
        *   전체 스트림 파이프라인 의 비용은  N * Q 이다. Q가 높아진다는것은 병렬 스트림으로 성능을 개선할 수 있는
        *   가능성이 있음을 의미한다.
        * - 소량의 데이터에서는 병렬 스트림이 도움되지 않는다. 소량의 데이터를 처리하는 상황에서는 병렬화 과정에서 생기는
        *   부가 비용을 상쇄할 수 있을 만큼의 이득을 얻지 못하기 때문이다.
        * - 스트림을 구성하는 자료구조가 적절한지 확인하라. ArrayList 를 LinkedList 보다 효율적으로 분할할 수 있다.
        *   LinkedList 를 분할하려면 모든 요소를 탐색해야 하지만 ArrayList 는 요소를 탐색하지 않고도 리스트를 분할 할 수 있기 때문이다.
        * - 스트림의 특성과 파이프라인의 중간 연산이 스트림의 특성을 어떻게 바꾸는지에 따라 분해 과정의 성능이 달라질 수 있다.
        *   SIZED 스트림은 정확히 같은 크기의 두 스트림으로 분할할 수 있으므로 효과적으로 스트림을 병렬 처리할 수 있다.
        *   반면 필터 연산이 있으면 스트림의 길이를 예측할 수 없으므로 효과적으로 스트림을 병렬 처리할 수 있을지 알 수 없게된다.
        * - 최종 연산의 병합과정 비용을 살펴봐야한다. 병합 과정에서의 비용이 비싸다면 병렬 스트림으로 처리한 이득이 상쇄 될 수 있다.
        * */
        System.out.println("SideEffect parallel sum done in : " +
                measurePerf(ParallelStreams::sideEffectParallelSum, 10_000_000L) + " msecs");
    }

    public static <T, R> long measurePerf(Function<T, R> function, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R result = function.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result = " + result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}
