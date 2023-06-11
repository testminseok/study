package chapter02.item44;

import java.util.LinkedHashMap;

public class StandardInterfaceMap extends LinkedHashMap {
    private static final int MAX_ENTRIES = 100;

    // LinkedHashMap의 removeEldestEntry 메서드를 재정의한다.
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
}
