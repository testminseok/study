package chapter02.item01;

import java.math.BigInteger;
import java.net.http.HttpHeaders;
import java.util.EnumSet;
import java.util.Random;

/**
 * item01 - 생성자 대신 정적 팩터리 메서드를 고려하라
 * */
public class StaticFactoryMethod {

    public static void main(String[] args) {
        int bitLength = 1;
        int certainty = 1;
        Random random = new Random();

        /*
         * 정적 팩터리 메서드의 장점 첫번째 : 이름을 가질 수 있다.
         *  - 생성자를 통한 BigInteger(bitLength, certainty, random); 와
         *    정적 메소드인 BigInteger.probablePrime(bitLength, random); 중
         *    어떤것이 소수인 BigInteger 를 반환하는지 명확하게 알 수 있다.
         *    또한 메서드 시그니처가 같을 경우 생성자 추가는 불가능하지만 정적 메서드는 동일 시그니처에 이름만 명확하게 작성하면 된다.
         * */
        BigInteger constructValue = new BigInteger(bitLength, certainty, random);
        BigInteger staticMethodValue = BigInteger.probablePrime(bitLength, random);

        /*
        * 정적 팩터리 메서드의 장점 두번째 : 호출될 떄마다 인스턴스를 새로 생성하지는 않아도 된다.
        *  - 따라서 생성 비용이 큰 같은 객체가 자주 요청되는 상황이라면 성능을 상당히 끌어올려 준다.
        *  - 또한 인스턴스를 상아 있게 할지를 철저히 통제할 수 있다. (인스턴스 통제)
        *  - 인스턴스 통제하면 클래스를 singleton 으로 만들 수도, 인스턴스 불가로 만들수도 있다.
        *  - 또한 불변 값 클래스에서 동치인 인스턴스가 단 하나뿐임을 보장할 수 있다. (a == b 일때만 a.equals(b))
        * */
        Boolean boolValue = Boolean.valueOf(true);

        /*
        * 정적 팩터리 메서드의 장점 세번째 : 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
        * */

        /*
         * 정적 팩터리 메서드의 장점 네번째 : 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
         *  - EnumSet 은 원소가 64개 이하면 원소들을 변수 하나로 관리하는 RegularEnumSet 의 인스턴스를
         *    65개 이상이면 long 배열로 관리하는 JumboEnumSet 의 인스턴스를 반환한다.
         * */
        EnumSet enumSet = EnumSet.of(StatusCode.CODE1, StatusCode.CODE2);

        /*
         * 정적 팩터리 메서드의 장점 다섯번째 : 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
         * */

        /*
         * 정적 팩터리 메서드의 단점 첫번째 : 상속을 하려면 public 이나 protected 생성자가 필요하니 정적 팰터리 메서드만 제공하면
         *                               하위 클래스를 만들 수 없다.
         *  - 이 제약은 상속보다 컴포지션을 사용하도록 유도하고 불변차입으로 만들려면 이 제약을 지켜야 한다는 점에서는 오히려 장점일 수 있다.
         * */

        /*
         * 정적 팩터리 메서드의 단점 두번째 : 정적 팩터리 메서드는 프로그래머가 찾기 어렵다.
         *  - 생성자처럼 API 설명에 명확히 들어나지 않으니 사용자는 정적 팩터리 메서드 방식 클래스를 인스턴스화할 방법을 알아내야한다.
         *    API 문서를 잘 써놓고 메서드 이름도 널리 알려진 유약을 따라 짓는 식으로 문제를 완화한다.
         *    (from, of, valueOf, instance, getInstance, create, newInstance, get[Type], new[Type], [type] 등..)
         * */
    }

    enum StatusCode {
        CODE1,
        CODE2,
    }
}
