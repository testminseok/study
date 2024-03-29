# 일반적으로 통용되는 명명 구칙을 따르라
자바 플랫폼은 명명 규칙이 잘 정립되어 있으며, 그중 많은 것이 자바 언어 명세[JLS, 6.1]에 기술되어 있다.
자바의 명명 규칙은 크게 철자와 문법, 두 범주로 나뉜다.

철자 규칙은 패키지, 클래스, 인터페이스, 메서드, 필드, 타입 변수의 이름을 다룬다.

- 패키지
> 패키지와 모듈 이름은 각 요소를 점(.)으로 구분하여 계층적으로 짓는다. 요소들은 모두 소문자 알파벳 혹은
드물게 숫자로 이뤄진다. 조직 바깥에서도 사용될 패키지라면 조직의 인터넷 도메인 이름을 역순으로 사용한다.
ex) com.google.inject, com.google.common.collect
패키지 이름의 나머지는 해당 패키지를 설명하는 하나 이상의 요소로 이뤄진다. 각요소는 일반저긍로 8자 이하의 짧은 단어로한다.
여러 단어로 구성된 이름이라면 awt 처럼 각 단어의 첫 글자만 따서 써도 좋다.

- 클래스와 인터페이스
> (열거 타입과 애너테이션을 포함해) 클래스와 인터페이스의 이름은 하나 이상의 단어로 이뤄지며, 각단어는
대문자로 시작한다(List, FutureTask 등). 여러 단어의 첫 글자만 딴 약자나 max, min 처럼 널리 통용되는 줄임말을 제외하고는
단어를 줄여 쓰지 않도록 한다.
약자의 경우 첫 글자만 대문자로 할지 전체를 대문자로 할지는 논란이 있지만. 첫글자만 대문자로 하는 쪽이 훨씬 많다.
HttpUrl 처럼 여러 약자가 혼합된 경우라도 각 약자의 시작과 끝을 명확히 알 수 있기 때문이다.

- 메서드
> 메서드와 필드 이름은 첫 글자를 소문자로 쓴다는 점만 빼면 클래스 명명 규칙과 같다. 첫 단어가 약자라면 단어 전체가 소문자여야한다.
> 단 '상수 필드'는 예외다. 상수 필드를 구성하는 단어는 모두 대문자로 쓰며 단어 사이는 밑줄로 구분한다. 
> 상수 필드는 값이 불변인 static final 필드를 말한다. 달리 말하면 static final 필드의 타입이 기본 타입이나 불변 참조 타입이라면
> 상수 필드에 해당한다. static final 필드이면서 가리키는 객체가 불변이라면 비록 그 타입은 가변이더라도 상수필드다.

- 지역변수
> 지역변수에도 다른 멤버와 비슷한 명명 규칙이 적용된다. 단, 약어를 써도 좋다. 
> 약어를 써도 그 변수가 사용되는 문맥에서 의므를 쉽게 유추할 수 있기 때문이다.
> 입력 매개변수도 지역변수의 하나다. 하지만 메서드 설명 문서에까지 등장하는 만큼 일반 지역변수보다는 신경써야한다.

- 타입매개변수
> 타입 매개변수 이름은 보통 한 문자로 표현한다. 대부분 다음의 다섯 가지 중 하나다. 임의의 타입엔 T를, 컬렉션 원소의 타입은 E를,
> 맵의 키와 값에는 K와 V를, 예외를 뜻하는 타입엔 X를, 메서드의 반환 타입에는 R을 사용한다.
> 그 외에 임의 타입의 시퀀스에는 T, U, V 혹은 T1, T2, T3를 사용한다.

- 문법 규칙
> 문법 규칙은 철자 규칙과 비교하면 더 유연하고 논란도 많다. 패키지에 대한 규칙은 따로 없다.
> 객체를 생성할 수 있는 클래스의 이름은 보통 단수 명사나 명사구를 사용한다.(Thread, PriorityQueue)
> 객체를 생성할 수 없는 클래스의 이름은 보통 북수형 명사로 짓는다.(Collections, Arrays, Collectors).
> 인터페이스 이름은 클래스와 똑같이 짓거나(Comparable, Closeable), able 혹은 ible로 끝나는 형용사로 짓는다.(Runnable, Iterable)
> 어노테이션은 지배적인 규칙이 없이 명사, 동사, 전치사, 형용사가 두루 쓰인다.
> 어떤 동작을 수행하는 메서드의 이름은 동사나 (목적어를 포함한) 동사구로 짓는다.(append, drawImage, getBackground)
> boolean 값을 반환하는 메서드라면 보통 is나 has로 시작하고 명사나 명사구, 혹은 형용사로 기능하는 아무 단어나 구로 끝나도록 짓는다.
> 예를 들어, setEnabled, isEmpty, isDigit, isProbablePrime 등이다.
> 반환 타입이 boolean이 아니거나 해당 인스턴스의 속성을 반환하는 메서드의 이름은 보통 명사, 명사구, 혹은 get으로 시작하는 동사구로 짓는다.
> 예를 들어, size, hashCode, getTime, getImpage 등이다.
> 객체의 타입을 바꿔서, 다른 타입의 또 다른 객체를 반환하는 메서드는 보통 toType 형태의 이름을 사용한다. 예를 들어, toString, toArray 등
> 객체의 내용을 다른 뷰로 보여주는 메서드의 이름은 asType 형태로 짓는다. 예를 들어, asList, asMap, asSet 등이다.
> 객체의 값을 기본 타입 값으로 표현하는 메서드의 이름은 보통 typeValue 형태로 짓는다. 예를 들어, intValue 등
> 정적 팩터리 메서드의 이름은 보통 from, of, valueOf, instance, getInstance, newInstance, getType, newType 형태로 짓는다.

- 핵심정리
> 표준 명명 규칙을 체화하여 자연스럽게 베어 나오도록 하자. 철자 규칙은 직관적이라 모호한 부분이 적은 데 반해,
> 문법 규칙은 더 복작하고 느슨하다. 자바 언어 명세[JLS, 6.1]의 말을 인용하면 "오랫동안 따라온 규칙과 충돌한다면 그 규칙을 맹종해서는 안된다."
> 상식이 이끄는 대로 따르자.