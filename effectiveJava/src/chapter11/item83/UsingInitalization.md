# 지연 초기화는 신중히 사용하라
지연 초기화는 필드의 초기화 시점을 그 값이 처음 필요할 때까지 늦추는 방법이다.
주로 최적화 용도로 쓰이지만, 클래스와 인스턴스 초기화 때 발생하는 위험한 순환 문제를 해결하는 효과도 있다.

**대부분의 상황에서 일반적인 초기화가 지연 초기화보다 낫다.**
그러나, 지연 초기화가 필요할 때도 있다. 예를 들어 클래스의 인스턴스 중 그 필드를 사용하는 인스턴스의 비율이 낮은 반면,
그 필드를 초기화 하는 비용이 크다면 지연 초기화가 제 역활을 해줄 것이다.
하지만 안타깝지만 정말로 개선되었는지는 지연 초기화 적용 전후로 성능을 측정해보는것 뿐이다.

다음은 일반 적인 초기화의 모습이다. final 한정자를 사용했다는 것에 주목하자.
```java
private final FieldType field = computeFieldValue()
```
지연 초기화가 초기화 순환성(initialization circularity)을 깨트릴 것 같으면 synchronized 한정자를 추가해야 한다.
이 방법이 가장 간단하고 명확한 대안이다.
```java
private FieldType field;

private synchronized FieldType getField() {
    if (field == null) {
        field = computeFieldValue();
    }
    return field;
}
```
**성능 때문에 정적 필드를 지연 초기화해야 한다면 지연 초기화 홀더 클래스(lazy initialization holder class) 관용구를 사용하자**
클래스는 클래스가 처음 쓰일 때 비로소 초기화 된다는 특성을 이용한 관용구이다.
```java
private static class FieldHolder {
    static final FieldType field = computeFieldValue();
}

private static FieldType getField() {
    return FieldHolder.field;
}
```
이 관용구는 getField 가 처음 호출될 때 FieldHolder.field 를 초기화하고, 이 값은 getField 의 반환값으로 사용된다.

**성능 때문에 인스턴스 필드를 지연 초기화해야 한다면 이중검사(double-check) 관용구를 사용하라**
이 관용구는 초기화된 필드에 접근할 때의 동기화 비용을 없애준다.
```java
private volatile FieldType field;

private FieldType getField() {
    FieldType result = field;
    if (result != null) { // 첫 번째 검사 (락 사용 안함)
        return result;
    }

    synchronized(this) {
        if (field == null) { // 두 번째 검사 (락 사용)
            field = computeFieldValue();
        }
        return field;
    }
}
```
한번은 동기화 없이 검사하고. 두번째 검사에서도 칠드가 초기화되지 않았을 때만 필드를 초기화한다.
필드가 초기화된 후 동기화하지 않으므로 해당 필드는 반드시 volatile 한정자로 선언해야 한다.

반복해서 초기화해도 상관 없는 인스턴스 필드는 이중검사에서 두 번째 검사를 생략할 수 있다.
필드는 여전히 volatile 한정자로 선언해야 한다.
```java
private volatile FieldType field;

private FieldType getField() {
    FieldType result = field;
    if (result == null) {
        field = result = computeFieldValue();
    }
    return result;
}
```

## 정리
대부분의 필드는 지연시키지 말고 곧바로 초기화해야 한다. 성능 때문에 혹은 위험한 초기화 순환을 막기 위해 꼭 지연 초기화를 써야 한다면
올바른 지연 초기화 기법을 사용하자. 인스턴스 필드에는 이중검사 관용구를, 정적 필드에는 지연 초기화 홀더 클래스 관용구를 사용하자.
반복해 초기화해도 괜찮은 인스턴스 필드에는 단일검사 관용구도 고려 대상이다.
