package chapter08.item56;

import java.util.ArrayList;
import java.util.List;

public class WriteDocComment<E> {
    private final List<E> list = new ArrayList<>();

    /**
     * 이 리스트에서 지정한 위치의 원소를 반환한다.
     *
     * <p>이 메서드에서 상수 시간에 수행됨을 보장하지 <i>않는다</i>. 구현에 따라
     * 원소의 위치에 비례해 시간이 걸릴 수도 있다.</p>
     *
     * @param index 반환할 원소의 인덱스; 0이상이고 리스트 크기보다 작아야한다.
     * @return 이 리스트에서 지정한 위치의 원소
     * @throws IndexOutOfBoundsException index가 범위를 벗어나면,
     *       즉 {@code index < 0 || index >= size()}이면 발생한다.
     * */
    public E get(int index) {
        return list.get(index);
    }

    /**
     * 이 컬렉션이 비었다면 true 를 반환한다.
     *
     * @implSpec 이 구현은 {@code this.size() == 0}의 결과를 반환한다.
     * @return 이 컬렉션이 비었다면 true, 그렇지 않으면 false
     * */
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
