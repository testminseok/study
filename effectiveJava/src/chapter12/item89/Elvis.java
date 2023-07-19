package chapter12.item89;

import java.io.Serializable;
import java.util.Arrays;

/**
 * - readResolve 를 인스턴스 통제 목적으로 사용한다면 객체 참조 타입 인스턴스 필드는 모두 transient 로 선언해야 한다.
 * - readResolve 메서드의 접근성은 매우 중요하다.
 *   메서드의 접근제한자가 protected 나 public 이면서 하위 클래스에서 재정의 하지 않았다면,
 *   하위 클래스의 인스턴스를 역직렬화하면 상위 클래스의 인스턴스를 생성하여 ClassCaseException 을 일으킬 수 있다.
 *
 * 정리
 * 불변식을 지키기 위해 인스턴스를 통제해야 한다면 가능한 한 열거 타입을 사용하자.
 * 여의치 않은 상황에서 직렬화와 인스턴스 통제가 모두 필요하다면 readResolve 메서드를 작성해 넣어야 하고,
 * 그 클래스에서 모든 참조 타입 인스턴스 필드를 transient 로 선언해야 한다.
 * */
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() { }

    // transient 가 아닌 참조 필드를 가지고 있다.
    private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
