package chapter02.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AccessModifierExample {

    // 추상 개념을 완성하는 데 꼭 필요한 구성요소로써의 상수라면 public static final 로 공개해도 좋다.
    public static final String CONSTANT = "constant";

    /*
    * 배열은 public static final 로 선언하면 안된다. 재할당만 막을 뿐 배열의 내용을 변경하는 것은 막을 수 없기 때문이다.
    * 이러한 허점을 막기 위해선 배열을 private 으로 선언하고 public 으로 선언된 불변 리스트를 추가해야 한다.
    *
    * 두번째 방법은
    * 배열을 private 으로 만들고 그 복사본을 반환하는 public 매서드를 추가하는 방법이다.(방어적 복사)
    * */
    private static final AccessModifierExample[] VALUE = {};
    public static final List<AccessModifierExample> VALUES_LIST = Collections.unmodifiableList(Arrays.asList(VALUE));

    // public 접근 제한자는 어디서든 접근이 가능하다. 따라서 공개된 API 로 하위 호환성을 위해 영원히 관리해야 한다.
    public String publicField = "public";

    /*
    * public 클래스의 인스턴스 필드는 되도록 public 이 아니어야 한다.\
    * final 이 아닌 인스턴스 필드를 public 으로 선언하면 그 필드에 담을 수 있는 값을 제한할 힘을 잃게된다.
    * public 가변 필드를 갖는 클래스는 일반적으로 스레드 세이프 하지 않는다.
    * */
    public AccessModifierExample accessModifierExample = new AccessModifierExample();

    /*
    * protected 접근 제한자는 같은 패키지 내에서는 접근이 가능하고, 다른 패키지에서는 상속받은 경우에만 접근이 가능하다.
    * 따라서 공개된 API 로 하위 호환성을 위해 영원히 관리해야 한다.
    * */
    protected String protectedField = "protected";

    // package-private 접근 제한자는 같은 패키지 내에서만 접근이 가능하다.
    String packagePrivateField = "packagePrivate";

    // private 접근 제한자는 같은 클래스 내에서만 접근이 가능하다.
    private String privateField = "private";
}
