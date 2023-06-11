package chapter02.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class InstrumentedSetAsComposition<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSetAsComposition() {
        super(new HashSet<>());
    }
    public InstrumentedSetAsComposition(Set<E> s) {
        super(s);
    }

    public static void main(String[] args) {
        InstrumentedSetAsComposition<String> s = new InstrumentedSetAsComposition<>();
        s.addAll(Set.of("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
