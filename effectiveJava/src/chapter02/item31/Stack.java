package chapter02.item31;

import java.util.*;

public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        numberStack.pushAll(integers);

        List<Object> objectStack = new ArrayList<>();
        numberStack.popAll(objectStack);
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        E element = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제(null 처리)
        return element;
    }

    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }
    
    // Comparable 은 언제나 소비자 이므로 Comparable<E> 보다 Comparable<? super E> 를 사용해야 한다.
    // PECS - producer-extends, consumer-super 생산자라면 extends 소비자라면 super 를 사용하자 
    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
        return null;
    }
    
    // 비한정적 타입 매개변수를 사용한 정적 메서드
    // 메서드 선언에 타입 매개변수가 한 번만 나오면 와일드카드로 교체하라
    public static <E> void swapTypeParameter(List<E> list, int i, int j) {
        
    }

    // 비한정적 와일드카드를 사용한 정적 메서드
    public static void swap(List<?> list, int i, int j) {
//        list.set(i, list.set(j, list.get(i))); // 컴파일 에러 List<?> 에는 null 이외에는 넣을 수 없다.
        swapHelper(list, i, j);
    }

    // 와일드카드 타입을 실제 타입으로 바꿔주는 private 도우미 메서드
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }


    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
     * */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
            // elements = Arrays.copyOf(elements, 2 * size);
        }
    }
}
