package chapter02.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /*
    * 문제의 배열 elements 는 private 필드에 저장되고, 클라이언트로 반환되거나 다른 메서드에 전달되는 일이 전혀없다.
    * push 메서드를 통해 배열에 저장되는 원소의 타입은 항상 E다. 따라서 이 비검사 형변환은 확실히 안전하기 때문에
    * @SuppressWarnings("unchecked") 애너테이션을 달아 경고를 숨긴다.
    * */
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String arg : args) {
            stack.push(arg);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        E element = elements[--size];
//        @SuppressWarnings("unchecked")
//        E element = (E) elements[--size]; // elements 의 타입을 Object[] 로 변환한다.
        elements[size] = null; // 다 쓴 참조 해제(null 처리)
        return element;
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
