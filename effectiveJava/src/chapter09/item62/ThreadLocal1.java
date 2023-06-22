package chapter09.item62;

/**
 * 더 적합한 데이터 타입이 있거나 새로 작성할 수 있다면, 문자열을 쓰고 싶은 유혹을 뿌리쳐라.
 * 문자열은 잘못 사용하면 번거롭고, 덜 유연하고, 느리고, 오류가능성도 크다.
 * 문자열을 잘못 사용하는 흔한 예로는 기본 타입, 열거 타입, 혼합 타입이 있다.
 * */
public class ThreadLocal1 {
    private ThreadLocal1() {
    }

    public static class Key {
        Key() {
        }
    }

    // 위조 불가능한 고유 키를 생성한다.
    public static Key getKey() {
        return new Key();
    }

    // Key 클래스로 권한을 구분했다.
    public static void set(Key key, Object value) {
    }

    public static Object get(Key key) {
        return null;
    }

    // 잘못된 예 - 문자열을 사용해 권한을 확인한다.
    // 현 스레드의 값을 키로 구분해 저장한다.
    public static void set(Object value) {
    }

    // (키가 가리키는) 현 스레드의 값을 반환한다.
    public static Object get() {
        return null;
    }
}
