package chapter02.item20;

import java.util.Map;
import java.util.Objects;

// Map.Entry 의 골격구현 클래스
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException("you most override this method.");
    }

    // Map.Entry.equals의 일반 규약을 구현한다.
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Map.Entry)) {
            return false;
        }

        Map.Entry<?, ?> e = (Map.Entry) o;
        return Objects.equals(e.getKey(), getKey()) && Objects.equals(e.getValue(), getValue());
    }

    // Map.Entry.hashCode의 일반 규약을 구현한다.
    @Override
    public int hashCode() {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }

    @Override
    public String toString() {
        return getKey() + "=" + getValue();
    }
}
