package chapter02.item44;

import java.util.Map;

/**
 * 부필요한 함수형 인터페이스 - 대신 표준 함수형 인터페이스를 사용하라.
 * 직접 만든 함수형 인터페이스에는 항상 @FunctionalInterface 애너테이션을 사용하라.
 * 보통은 java.util.function 패키지의 표준 함수형 인터페이스를 사용하는 것이 가장 좋은 선택이다.
 * 단, 흔치 않지만 직접 새로운 함수형 인터페이스를 만들어 쓰는 편이 나을 수 있다.
 * ex) 3개의 인수를 받는 Predicate<T, U, V> 같은 경우
 * */
@FunctionalInterface
public interface EldestEntryRemovalFunction<K, V> {
    boolean remove(Map<K, V> map, Map.Entry<K, V> eldest);
}
