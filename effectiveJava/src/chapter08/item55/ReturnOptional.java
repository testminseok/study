package chapter08.item55;

import java.util.*;

/**
 * 값을 반환하지 못할 가능성이 있고, 호출할 때마다 반환값이 없을 가능성을 염두에 둬야하는 메서드라면
 * 옵셔널을 반환해햐 할 상황일 수 있다. 하지만 옵셔널 반환에는 성능 저하가 뒤따르니,
 * 성능에 민감한 메서드라면 null 을 반환하거나 예외를 던지는 편이 나을 수 있다.
 * 그리고 옵셔널을 반환값 이외의 용도로 쓰는 경우는 매우 드물다.
 * */
public class ReturnOptional {

    private static final List<String> words = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    // 컬렉션에서 최대 값을 구한다. - 컬렉션이 비었으면 예외를 던진다.
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("컬렉션이 비어 있습니다.");
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return result;
    }

    // 컬렉션에서 최대값을 구해 Optional<E> 로 반환한다.
    public static <E extends Comparable<E>> Optional<E> max2(Collection<E> c) {
        if (c.isEmpty()) {
            Optional.empty();
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return Optional.of(result);
    }

    // 컬렉션에서 최대값을 구해 Optional<E> 로 반환한다. - 스트림 버전
    public static <E extends Comparable<E>> Optional<E> max3(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    public static void main(String[] args) {
        // 옵셔널 활용1 - 기본값을 정해둘 수 있다.
        String lastWordInLexicon = max2(words).orElse("단어 없음...");

        // 옵셔널 활용2 - 원하는 예외를 던질 수 있다.
        String lastWordInLexicon2 = max2(words).orElseThrow(NoSuchElementException::new);

        // 옵셔널 활용3 - 항상 값이 채워져 있다고 가정한다.
        String lastWordInLexicon3 = max2(words).get();


        Optional<ProcessHandle> parentProcess = ProcessHandle.current().parent();
        System.out.println("부모 PID: " + (parentProcess.isPresent() ? String.valueOf(parentProcess.get().pid()) : "N/A"));
        System.out.println("부모 PID: " + parentProcess.map(h -> String.valueOf(h.pid())).orElse("N/A"));
    }
}
