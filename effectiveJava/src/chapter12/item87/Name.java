package chapter12.item87;

import java.io.Serializable;

/**
 * 먼저 고민해보고 괜찮다고 판단될 때만 기본 직렬화를 사용하라. 기본직결화 형태는 유연성, 성능, 정확성 측면에서 신중히 고민한 후
 * 합당할 때만 사용해야한다.
 *
 * 객체의 물리적 표현과 논리적 내용이 같다면 기본 직렬화 형태라도 무방하다.
 * 기본 직렬화 형태가 적합하다고 결정했더라도 불변식 보장과 보안을 위해 readObject 메서드를 제공해야 할 때가 많다.
 * */
public class Name implements Serializable {
    /**
     * 성. null이 아니어야 한다.
     * @serial
     */
    private final String lastName;

    /**
     * 이름. null이 아니어야 한다.
     * @serial
     */
    private final String firstName;

    /**
     * 중간이름. 중간이름이 없다면 null.
     * @serial
     */
    private final String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
}
