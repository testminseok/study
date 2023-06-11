package chapter03.item14;

import java.util.Objects;

public class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public int compareTo(CaseInsensitiveString o) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, o.s);
    }
}
