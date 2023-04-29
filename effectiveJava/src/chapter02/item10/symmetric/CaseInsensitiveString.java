package chapter02.item10.symmetric;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        // 대칭성 위배!
        System.out.println(cis.equals(s)); // true

        // String 의 equals 메서드는 대소문자를 구분한다.
        System.out.println(s.equals(cis)); // false

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println(list.contains(s)); // false;

    }

    // 대칭성 위배!
    @Override
    public boolean equals(Object o) {
        // CaseInsensitiveString 의 equals 를 String 과도 연동한다는 생각은 허황된 꿈이다.
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
//        if (o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//        }
//
//        if (o instanceof String) { // 한 방향으로만 작동한다!
//            return s.equalsIgnoreCase((String) o);
//        }
//        return false;
    }
}
