package chapter10.item69;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 상태 검사 메서드 대신 사용할 수 있는 선택지도 있다. 올바르지 않은 상태일 때 빈 옵셔널 혹은  null 과 같은 특수한 값을 반환하는 방법이다.
 * 상태 검사 메서드, 옵셔널, 특정 값 중 하나를 선택하는 지침
 * 1. 외부 동기화 없이 여러 스레드가 동시에 접근할 수 있거나 외부 요인으로 상태가 변할 수 있다면 옵셔널이나 특정 값을 사용해야한다.
 *    상태 검사 메서드와 상태 의존적인 메서드 호출 사이에 객체의 상태가 변할 수 있기 때문이다.
 * 2. 성능이 중요한 상황에서 상태 검사 메서드가 상태 의존적 메서드의 작업일부를 중복 수행한다면 옵셔널이나 특정 값을 사용해야한다.
 * 3. 다른 모든 경우엔 상태 검사 메서드 방식이 조금 더 낫다. 가독성이 살짝 더 좋고, 잘못 사용했을 때 발견하기가 더 쉽다.
 *    상태 검사 메서드 호출을 깜빡 잊었다면 상태 의존적 메서드가 예외를 던지며 버그를 확실히 드러낼 것이다.
 *
 * 예외는 예외 상황에서 쓸 의도로 설계되었다. 정상적인 제어 흐름에서 사용해서는 안되며,
 * 이를 프로그래머에게 강요하는 API를 만들어서도 안된다.
 * */
public class UseExceptionsOnlyForExceptionalConditions {

    private static Range[] range = new Range[100];

    public static void main(String[] args) {
        /*
        * 예외를 완전히 잘못 사용한 예 - 따라 하지 말 것!
        * 예외는 (그 이름이 말해주듯) 오직 예외 상황에서만 사용해야 한다.
        * 절대로 일상적인 제어 흐름용으로 쓰여선 안 된다.
        * */
        try {
            int i = 0;
            while (true) {
                range[i++].climb();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // 배열의 끝에 도달했으니 종료한다.
        }

        // 표준적인 관용구
        for (Range range : range) {
            range.climb();
        }

        /*
        * 잘 설계된 API라면 클라이언트가 정상적인 제어 흐름에서 예외를 사용할 일이 없게 해야한다.
        * 특정 상태에서만 호출할 수 있는 '상태 의존적'메서드를 제공하는 클래스는 '상태 검사' 메서드도 함께 제공해야 한다.
        * Iterator 인터페이스의 next 와 hasNext 가 각각 상태 의존적 메서드와 상태 검사 메서드에 해당한다.
        * */
        List<Foo> collection = new ArrayList<>();
        for (Iterator<Foo> i = collection.iterator(); i.hasNext(); ) {
            Foo foo = i.next();
            // ... // i와 foo를 사용한다.
        }
        
        // Iterator 가 hasNext 를 제공하지 않는다면 다음과 같이 구현해야 한다.
        // 컬렉션을 이런 식으로 순회하지 말것
        try {
            Iterator<Foo> i = collection.iterator();
            while (true) {
                Foo foo = i.next();
                // ... // i와 foo를 사용한다.
            }
        } catch (Exception e) {
            // ... // 예외 상황에 대처한다.
        }
    }

    private static class Range {
        public void climb() {
        }
    }

    private static class Foo {
    }
}
