package chapter09.item61;

import java.util.Comparator;

/**
 * 박싱된 기본타입은 컬력센의 원소, 키, 값으로 쓴다.
 * 더 일반화 하면 매개변수화 메서드의 매개변수로는 박싱된 기본타입을 써야한다.
 * 리플렉션을 통해 메서드를 호출할 때도 박싱된 기본타입을 사용한다.
 *
 * 기본타입과 박싱된 기본타입의 차이
 * 1. 기본타입은 값만 가지고 있으나, 박싱된 기본타입은 값에 더해 식별성이라는 속성을 갖는다.
 * 2. 기본타입의 값은 언제나 유효하나, 박싱된 기본타입은 null 을 가질 수 있다.
 * 3. 기본 타입이 박싱된 기본 타입보다 시간과 메모리 사용면에서 더 효율적이다.
 *
 * 기본 타입과 박싱된 기본 타입 중 하나를 선택해야 한다면 가능하면 기본 타입을 사용하자.
 * 기본 타입은 간단하고 빠르다. 박싱된 기본 타입을 써야 한다면 주의를 기울이자.
 * 오토박싱이 박싱된 기본 타입을 사용할 때의 번거로움을 줄여주지만, 그 위험까지 없애주지는 않는다.
 * 두 박싱된 기본 타입을 == 연산자로 비교한다면 식별성 비교가 이뤄지는데, 이는 개발자가 원한게 아닐 가능성이 크다.
 * 같은 연산에서 기본 타입과 박싱된 기본타입을 혼용하면 언박싱이 이뤄지며, 언박싱 과정에서 NPE 가 발생할 수 있다.
 * 기본 타입을 박싱하는 작업은 필요 없는 객체를 생성하는 부작용을 나을 수 있다.
 * */
public class UseThePrimitiveType {
    public static void main(String[] args) {
        // 잘못된 구현된 비교자 - 문제를 찾아보자
        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        // i == j 에서 객체의 식별성 때문에 == 연산자를 사용하여 다른 값이 된다.
        System.out.println(naturalOrder.compare(new Integer(42), new Integer(42))); // 0 을 예상하지만 1이 나온다.

        // 문제를 수정한 비교자
        Comparator<Integer> naturalOrder2 = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed; // 오토박싱
            return i < j ? -1 : (i == j ? 0 : 1); // 오토박싱
        };

        System.out.println(naturalOrder2.compare(new Integer(42), new Integer(42))); // 0 이 출력된다.
    }
}
