package chapter03.item13;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 코드 7-1 메모리 누수가 일어나는 위치는 어디인가? (37쪽)
    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        Object element = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제(null 처리)
        return element;
    }

    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack stack = (Stack) o;
        return size == stack.size && Arrays.equals(elements, stack.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    @Override
    protected Stack clone() throws CloneNotSupportedException {

        /*
        * elements 필드는 원본 Stack 인스턴스와 똑같은 배열을 참조하므로,
        * 원본이나 복제본 중 하나를 수정하면 다른 하나도 수정되어 불변식을 해친다.
        *
        * clone 메서드는 사실상 생성자와 동일한 효과를 낸다. 즉, clone 메서드는 본 객체에 아무런 해를 끼치지 않는
        * 동시에 복제된 객체의 불변식을 보장해야한다.
        * */
//        return super.clone();

        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            // 일어날 수 없는 일이다.
            throw new AssertionError();
        }
    }
}
