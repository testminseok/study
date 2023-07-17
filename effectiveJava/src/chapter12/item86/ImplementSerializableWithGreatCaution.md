# Serializable  을 구현할지는 신중히 결정하라
어떤 클래스의 인스턴스를 직렬화할 수 있게 하려면 클래스 선언에 implements Serializable 을 추가하면 된다.
너무 쉽게 사용할 수 있어 특별히 신경을 안써도 될거 같지만 실상은 훨씬 더 많은 신경을 써야한다.

**Serializable 을 구현하면 릴리스한 뒤에는 수정하기 어렵다.**
클래스가 Serializable 을 구현하면 직렬화된 바이트 스트림 인코딩도 하나의 공개 API 가 된다.
그래서 이 클래스가 많이 사용된다면 그 직렬화 형태도 영원히 지원해야 하는 것이다.
커스텀 직렬화 형태를 설계하지 않고 자바의 기본 방식을 사용하면 직렬화 형태는 최소 적용당시 클래스의 내부 구현 방식에 영원히 묶여버린다.
클래스의 private 과 package-private 인스턴스 필드마저 API로 공개되는 꼴이 된다.
그러니 직렬화 가능 클래스를 만들고자 한다면, 길게 보고 감당할 수 있을 만큼 고품질의 직렬화 형태도 주의해서 함께 설계해야 한다.
초기 개발 비용은 높아지지만 그만한 가치가 있다.

**Serializable 구현의 문제는 버그와 보안 구멍이 생길 위험이 높아진다**
객체는 생성자를 사용해 만드는게 기본이다. 즉, 직렬화는 언어의 기본 메커니즘을 우회하는 객체 생성 기법인 것이다.

**Serializable 구현의 문제는 해당 클래스의 신버전을 릴리스할 때 테스트할 것이 늘어난다.**
직렬화 가능 클래스가 수정되면 신버전 인스턴스를 직렬화한 후 구버전으로 역직렬화할 수 있는지, 그리고 그 반대도 가능한지를 검사해야한다.

**Serializable 구현 여부는 가볍게 결정할 사안이 아니다.**
단, 객체를 전송하거나 저장할 때 자바 직렬화를 이용하는 프레임워크용으로 만든 클래스라면 선택의 여지가 없다.
Serializable 을 반드시 구현해야 하는 다른 클래스의 컴포넌트로 쓰일 클래스도 마찬가지다.

**상속용으로 설계된 클래스는 대부분 Serializable 을 구현하면 안 되며, 인터페이스도 대부분 Serializable 을 확장해서는 안된다.**
예외적으로 Serializable 을 구현한 클래스만 지원하는 프레임워크를 사용하는 상황이라면 방도가 없다.
> 작성하는 클래스의 인스턴스 필드가 직렬화와 확장이 모두 가능하다면
> 인스턴스 필드 값 중 불변식을 보장해야 할 게 있다면 반드시 하위 클래스에서 finalize 메서드를 재정의하지 못하게 해야한다.
> 즉, finalize 메서드를 자신이 재정의하면서 final 로 선언하면 된다.
> 인스턴스 필드 중 기본값으로 초기화되면 위배되는 불변식이 있다면 클래스에 다음의 readObjectNoData 메서드를 반드시 추가해야 한다.
> ```java
> private void readObjectNoData() throws InvalidObjectException {
>    throw new InvalidObjectException("스트림 데이터가 필요합니다.");
> }
> ```
> 기존의 직렬화 가능 클래스에 직렬화 가능 상위 클래스를 추가하는 드문 경우를 위한 메서드다.

**내부 클래스는 직렬화를 구현하지 말아야한다.**
내부 클래스에는 바깥 인스턴스의 참조와 유효 범위 안의 지역변수 값들을 저장하기 위해 컴파일러가 생성한 필드들이 자동으로 추가된다.
익명 클래스와 지역 클래스의 이름을 짓는 규칙이 언어 명세에 나와 있지 않듯, 이 필드들이 클래스 정의에 어떻게 추가되는지도 정의되지 않았다.
내부 클래스에 대한 기본 직렬화 형태는 분명하지가 않다. 단, 정적 멤버 클래스는 Serializable 을 구현해도 된다.

## 정리
Serializable 은 구현한다고 선언하기는 아주 쉽지만, 그것은 눈속임일 뿐이다.
한 클래스의 여러 버전이 상호작용할 일이 없고 서버가 신뢰할 수 없는 데이터에 노출될 가능성이 없는 등,
보호된 환경에서만 쓰일 클래스가 아니라면 Serializable 구현은 아주 신중하게 다뤄야 한다.
상속할 수 있는 클래스라면 주의사항이 더욱 많아진다.