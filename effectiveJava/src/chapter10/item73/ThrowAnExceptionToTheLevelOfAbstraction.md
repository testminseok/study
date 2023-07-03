# 추상화 수준에 맞는 예외를 던지라
메서드가 저수준 예외를 처리하지 않고 바깥으로 전파해버릴 때 내부 구현 방식을 드러내어 윗 레벨의 API 를 오염시킨다.
다음 릴리스 구현 방식을 바꾸면 다른 예외가 튀어나와 기존 클라이언트 프로그램을 깨지게 할 수도 있다.

이 문제를 피하려면 상위 계층에서는 저수준 예외를 잡아 자신의 추상화 수준에 맞는 예외로 바꿔 던져야 한다.
이를 예외 번역이라 한다.

```java
// 예외 번역
try {
    ... // 저수준 추상화를 이용한다.
} catch (LowerLevelException e) {
    throw new HigherLevelException(...);
}
```

한가지 예로 AbstractSequentialList 는 List 인터페이스의 골격 구현이다. 
이 메서드에서 수행한 예외번역은 List<E> 인터페이스의 get 메서드에 명시된 필수사항이다.
```java
/**
 * 이 리스트 안의 지정한 위치의 원소를 반환한다.
 * @throws IndexOutOfBoundsException index가 범위 밖이면 발생한다.
 *        즉, ({@code index < 0 || index >= size()}) 이면 발생한다.
 * */
public E get(int index) {
    ListIterator<E> i = listIterator(index);
    try {
        return i.next();
    } catch (NoSuchElementException e) {
        throw new IndexOutOfBoundsException("Index: " + index);
    }
```
예외를 번역할 때, 저수준 예외가 디버깅에 도움이 된다면 예외 연쇄(chained exception)를 사용하는게 좋다.
예외 연쇄란 문제의 근본 원인(cause)인 저수준 예외를 고수준 예외에 실어 보내는 방식이다.
그러면 별도의 접근자 메서드(Throwable 의 getCause 메서드)를 통해 필요하면 언제든 저수준 예외를 꺼내 볼 수 있다.
```java
// 예외 연쇄
try {
    ... // 저수준 추상화를 이용한다.
} catch (LowerLevelException cause) {
    throw new HigherLevelException(cause);
}
```
고수준 예외의 생성자는 (예외 연쇄용으로 설계된) 상위 클래스의 생성자에 '원인'을 건네주어, 
최종적으로 Throwable(String, Throwable) 생성자까지 건네지게 된다.
```java
// 예외 연쇄용 생성자
class HigherLevelException extends Exception {
    HigherLevelException(Throwable cause) {
        super(cause);
    }
}
```

대부분의 표준 예외는 예외 연쇄용 생성자를 갖추고 있다. 그렇지 않은 예외라도 Throwable 의 initCause 메서드를 이용해 직접 원인을 설정할 수 있다.
예외 연쇄는 문제의 원인을 프로그램에서 접근할 수 있게 해주며, 원인과 고수준 예외의 스택 추적 정보를 잘 통합해준다.
**무턱대고 예외를 전파하는 것보다야 예외 번역이 우수한 방법이지만, 그렇다고 남용해서는 곤란하다.**
가능하다면 저수준 메서드가 반드시 성공하도록하여 아래 계층에서는 예외가 방생하지 않도록 하는것이 최선이다.

> 차선책으로는 아래 계층에서의 예외를 피할 수 없다면, 상위 계층에서 그 예외를 조용히 처리하여 문제를 API 호출자에까지 전파하지 않는 방법이 있다.
> 이 경우 발생한 예외는 java.util.logging 같은 적절한 로깅 기능을 활용하여 기록해두면 좋다.
> 그렇게 해두면 클라이언트 코드와 사용자에게 문제를 전파하지 않으면서도 개발자가 로그를 분석해 추가 조치를 취할 수 있게 해준다.

## 핵심정리
아래 계층의 예외를 예방하거나 스스로 처리할 수 없고, 그 예외를 상위 계층에 그대로 노출하기 곤란하다면 예외 번역을 사용하라.
이때 예외 연쇄를 이용하면 상위 계층에는 맥락에 어룰리는 고수준 예외를 던지면서 근본 원인도 함계 알려주어 오류를 분석하기에 좋다.