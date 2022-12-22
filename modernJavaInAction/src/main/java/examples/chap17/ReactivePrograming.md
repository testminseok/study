# ReactivePrograming
## Flow API
- Publisher
  - Publisher 가 항목을 발행하면 Subscriber 가 한 개씩 또는 한번에 여러 항목을 소비하는데
    이 과정을 관리 할 수 있도록 Flow 클래스는 관련된 인터페이스와 정적 메소드를 제공한다.
  - Publisher 는 수많은 일련의 이벤트를 제공할 수 있지만 Subscriber 의 요구사항에 따라 역압력 기법에 의해
  이벤트 제공 속도가 제한된다.
  - Publisher 는 자바의 함수형 인터페이스로, Subscriber 는 Publisher 가 발행한 리스너로 자신을 등록할 수 있다.
- Subscriber
  - Subscriber 인터페이스는 Publisher 가 관련 이벤트를 발행할 때 호출 할 수 있도록 
    onSubscribe, onNext, onError, onComplete 4개의 콜백 메소드를 정의한다.
  - onSubscribe onNext* (onError | onComplete) onSubscribe 가 항상 처음 호출되고 이어서
    onNext 가 여러 번 호출될 수 있다.
- Subscription
  - Subscription 은 Publisher 와 Subscriber 사이의 제어 흐름, 역압력을 관리한다.
  - request, cancel 두 개의 메소드를 정의한다. 
  - request 메소드는 Publisher 에게 주어진 개수의 이번트를 처리할 준비가 되었음을 알릴 수 있다.
  - cancel 메소드는 Publisher 에게 더 이상 이벤트를 받지 않음을 통지한다.
- Processor
- 규칙집합 정의
  - Publisher 는 반드시 Subscription 의 request 메소드에 정의된 개수 이하의 요소만 Subscriber 에 전달해야한다.
    하지만 Publisher 는 지정된 개수보다 적은 수의 요소를 onNext 로 전달할 수 있으며 동작이 성공적으로 끝났으면 onComplete 를 호출하고
    문제가 발행하면 onError 를 호출해 Subscription 을 종료할 수 있다.
  - Subscriber 는 요소를 받아 처리할 수 있음을 Publisher 에 알려야 한다. 이런 방식으로 Subscriber 는 Publisher 에 역압력을 행사할 수 있고
    Subscriber 가 관리할 수 없이 너무 많은 요소를 받는 일을 피할 수 있다. 더욱이 onComplete 나 onError 신호를 처리하는 상황에서
    Subscriber 는 Publisher 나 Subscription 의 어떤 메소드도 호출할 수 없으며, Subscription 이 취소 되었다고 가정해야 한다.
    Subscriber 는 Subscription.request() 메소드 호출이 없이도 언제든 종료 시그널을 받을 준비가 되어있어야 하며
    Subscription.cancel() 이 호출된 이후에라도 한 개 이상의 onNext 를 받을 준비가 되어 있어야한다.
  - Publisher 와 Subscriber 는 정확하게 Subscription 을 공유해야 하며 각각이 고유한 역할을 수행해야 한다.
    그러려면 onSubscribe 와 onNext 메소드에서는 Subscriber 는 request 메소드를 동기적으로 호출할 수 있어야 한다. 
    표준에서는 Subscription.cancel() 메소드는 몇 번을 호출해도 한 번 호출한것과 같은 효과를 가져야 하며,
    여러번 이 메소드를 호출해도 다른 추가 호출에 별 영향이 없도록 스레드에 안전해야 한다고 명시한다.
    같은 Subscriber 객체에 다시 가입하는 것은 권장하지 않지만 이런 상황에서 예외가 발생해야 한다고 명세서가 강제하진 않는다.
    이전의 취소된 가입이 영구적으로 적용되었다면 이후의 기능에 영향을 주지 않을 가능성도 있기 때문이다.



