package chapter02.item03;

/**
 * 정적 팩터리 방식의 장점
 *  - API 를 바꾸지 않고도 singleton 이 아니게 변경할 수 있다.
 *  - 정적 팩터리를 제네릭 singleton 팩터리로 만들 수 있다.
 *  - 정적 팩터리의 메서드 참조를 공급자(supplier)로 사용할 수 있다. (Jackson::getInstance)
 * */
public class Jackson {
    private static final Jackson INSTANCE = new Jackson();

    private Jackson() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static Jackson getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() { }

    // 싱글턴임을 보장해주는 readResolve 메서드
    private Object readResolve() {
        // 진짜 Jackson 객체를 반환하고 가짜 Jackson 객체는 가비지 컬렉터에 맡긴다.
        return INSTANCE;
    }
}
