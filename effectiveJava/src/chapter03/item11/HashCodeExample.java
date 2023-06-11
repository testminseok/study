package chapter03.item11;

import java.util.HashMap;
import java.util.Map;

public class HashCodeExample {
    public static void main(String[] args) {
        final short areaCode = 707;
        final short prefix = 867;
        final short lineNum = 5309;

        Map<PhoneNumber, String> m = new HashMap<>() {{
            put(new PhoneNumber(areaCode, prefix, lineNum), "제니");
        }};

        // PhoneNumber 의 hashCode 를 재정의하지 않았다면 null 을 출력한다.
        System.out.println(m.get(new PhoneNumber(areaCode, prefix, lineNum)));


    }
}
