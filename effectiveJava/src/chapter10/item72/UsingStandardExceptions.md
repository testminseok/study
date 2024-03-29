# 표준 예외를 사용하라
숙련된 개발자는 그렇지 못한 개발자 보다 더 많은 코드를 재사용한다.
예외 또한 마찬가지로 재사용하는 것이 좋으며, 자바에서는 대부분의 API 에서 쓰기에 충분한 수의 예외를 제공한다.

> 표준 예외를 사용하면 얻는것이 많은데, 그중 최고는 설계한 API가 다른사람이 익히고 사용하기 쉬워진다는 것이다. 
> 많은 개발자가 이미 익숙해진 규약을 그대로 따르기 때문이다. 
> API를 사용한 프로그램도 낯선 예외를 사용하지 않게 되어 읽기 쉽게 된다는 장점도 있으며, 
> 마지막으로 예외 클래스 수가 적을수록 메모리 사용량도 줄고 클래스를 적재하는 시간도 적게 걸린다.

가장 많이 재사용되는 표준 예외는 `IllegalArgumentException` 이다. 
API 를 호출할 때 인수로 부적절한 값을 넘길 때 사용할 수 있다.
예를 들면 인덱스 번호를 인수로 받고 List 에서 인덱스 번호의 원소를 반환하는 메서드가 있을 때 음수를 넘기는 경우이다.

두번째는 `IllegalStateException` 도 자주 사용된다.
이 예외는 대상 객체의 상태가 호출된 메서드를 수행하기에 적절하지 않을 때 던진다.
예를 들면 제대로 초기화되지 않은 객체를 사용하려 할 때 던질 수 있다.

> 메서드가 던지는 모든 예외를 잘못된 인수나 상태라고 할 수도 있겠지만, 그중 특수한 일부는 따로 구분해 쓰는게 보통이다. 
> null 을 허용하지 않는 메서드에 null 을 인수로 건네면 관례상 `IllegalArgumentException` 가 아닌 `NullPointerException` 을 던진다. 
> 비슷하게, 어떤 시퀀스의 허용 범위를 넘는 값을 건넬 때도 `IllegalArgumentException` 보다 `IndexOutOfBoundsException` 을 던지는게 관례이다.

> `IllegalArgumentException`, `IllegalStateException` 중 어느것을 사용하기 적합한지 헷갈린다면,
> **인수 값이 무엇이었든 어차피 실패했을거라면 IllegalStateException 을, 그렇지 않으면 IllegalArgumentException 을 사용하자.** 

재사용하기 좋은 또 다른 예외인 `ConcurrentModificationException` 은 단일 스레드에서 사용하려고 설계한 객체를 여러 스레드가 동시에
수정하려 할 때 던진다. 사실 동시 수정을 확실히 검출할 수 있는 안정된 방법이 없으니, 이 예외는 문제가 생길 가능성을 알려주는 정도의 역활로 쓰인다.

마지막으로 `UnsupportedOperationException` 은 호출한 메서드가 지원하지 않는 기능을 나타낼 때 던진다.
예를 들어 List 의 remove 메서드는 대부분의 List 구현체에서 지원하지만, 
불변 리스트는 지원하지 않으니 불변 리스트에서 `remove` 를 호출하면 `UnsupportedOperationException` 을 던진다.

> **Exception, RuntimeException, Throwable, Error 는 직접 재사용하지 말자.**
> 이 클래스들은 추상 클래스라고 생각하자. 이 예외들은 다른 예외들의 상위 클래스이므로, 즉 여러 성격의 예외들을 포괄하는 클래스이므로 
> 안정적으로 테스트할 수 없다.

## 핵심정리
상황에 부합한다면 항상 표준 예외를 사용하자. 이때 API 문서를 참고해 그 예외가 어떤 상황에서 던져지는지 꼭 확인해야 한다.
예외의 이름뿐 아니라 예외가 던져지는 맥락도 부합할 때만 재사용한다.
더 많은 정보를 제공하길 원한다면 표준 예외를 확장하자. 단, 예외는 직렬화할 수 있다는 사실을 기억하자.(직렬화에는 많은 부담이 따른다.)
이 사실 하나만으로도 예외를 새로 만들지 않아야 할 근거로 충분할 수 있다.