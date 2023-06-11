package chapter02.item47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectionBetterThenStreamForReturn {
    public static void main(String[] args) {

        // 자바 타입 추론의 한계로 컴파일되지 않는다.
//        for (ProcessHandle ph : ProcessHandle.allProcesses()::iterator) {
        // 스트림을 반복하기 위한 '끔직한' 우회 방법
        for (ProcessHandle ph : (Iterable<ProcessHandle>) ProcessHandle.allProcesses()::iterator) {

        }
        // 자바의 타입 추론이 문맥을 잘 파악하여 어댑터 메서드 안에서 따로 형변환 하지 않아도 된다.
        for (ProcessHandle ph : iterableOf(ProcessHandle.allProcesses())) {

        }
    }

    // Stream<E>를 Iterable<E>로 중개해주는 어댑터
    private static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    // Iterable<E>를 Stream<E>로 중개해주는 어댑터
    private static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
