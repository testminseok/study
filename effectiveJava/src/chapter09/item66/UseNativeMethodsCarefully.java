package chapter09.item66;

/**
 * 성능을 개선할 목적으로 네이티브 메서드를 사용하는 것은 거의 권장하지 않는다.
 *
 * 네이티브 메서드는 심각한 단점이 있는데
 * 네이티브 언어가 안전하지 않으므로 네이티브 메서드를 사용하는 애플리케이션도 메모리 훼손 오류로부터 더 이상 안전하지 않다.
 * 네이티브 언어는 자바보다 플랫폼을 많이 타서 이식성도 낮다.
 * 네이티브 메모리는 자동 회수하지 못하고 심지어 추적조차 할 수 없다.
 * 자바 코드와 네이티브 코드의 경계를 넘나들 때마다 비용도 추가된다.
 * 마지막으로 네이티브 메서드와 자바 코드 사이의 '접착 코드 (glue code)' 를 작성해야 한다. 이느 귀찮은 작업이며 가동석도 떨어진다.
 *
 * 네이티브 메서드를 사용하려거든 한번 더 생각하라. 네이티브 메서드가 성능을 개선해 주는 일은 많지 않다.
 * 저수준 자원이나 네이티브 라이브러리를 사용해야만 해서 어쩔 수 없더라도 네이티브 코드는 최소한만 사용하고 철저히 테스트하라
 * 네이티브 코드 안에 숨은 단 하나의 버그가 애플리케이션 전체를 훼손할 수 있다.
 * */
public class UseNativeMethodsCarefully {

    private native void hello();

    public static void main(String[] args) {
        new UseNativeMethodsCarefully().hello();
    }

}