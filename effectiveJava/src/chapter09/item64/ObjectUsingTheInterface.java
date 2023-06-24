package chapter09.item64;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 적합한 인터페이스만 있다면 매개변수뿐 아니라 반환값, 변수, 필드를 전부 인터페이스 타입으로 선언하라.
 * 인터페이스를 타입으로 사용하는 습관을 길러두면 프로그램이 훨씬 유연해질 것이다.
 * 적합한 인터페이스가 없다면 당연히 클래스로 참조해야 한다.
 * 적합한 인터페이스가 없다면 클래스의 계층구조 중 필요한 기능을 만족하는 가장 덜 구체적인 클래스를 타입으로 사용하자.
 *
 * 주의할 점
 * 원래의 클래스가 인터페이스의 일반 규약 이외의 특별한 기능을 제공하며, 주변 코드가 이 기능에 기대어 동작한다면 새로운
 * 클래스도 반드시 같은 기능을 제공해야한다.
 * 예를들어 첫 번째 선언의 주변 코드가 LinkedHashSet 이 따르는 순서 정책을 가정하고 동작하는 상황에서 이를 HashSet 으로
 * 바꾸면 문제가 생길 수 있다. LinkedHashSet 은 순서를 보장하지만 HashSet 은 그렇지 않기 때문이다.
 * */
public class ObjectUsingTheInterface {
    public static void main(String[] args) {

        // 좋은 예, 인터페이스를 타입으로 사용했다.
        Set<String> s = Set.of("a", "b", "c");

        // 나쁜 예, 클래스를 타입으로 사용했다.
        LinkedHashSet<String> sonSet = new LinkedHashSet<>();
    }
}
