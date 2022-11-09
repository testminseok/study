package examples.chap08;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ConCurrentHashMapExample {
    public static void main(String[] args) {
        /*
        * ConcurrentHashMap 클래스는 동시성 친화적이며 최신 기술을 반영한 HashMap 버전이다.
        * ConcurrentHashMap 는 내부 자료구조의 특벙 부분만 잠궈 동시 추가, 갱신 작업을 허용한다.
        * 따라서 동기화된 Hashtable 버전에 비해 읽기 쓰기 연산 성능이 월등하다. (표준 HashMap 은 비동기로 동작)
        * */
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        long parallelismThreshold = 1;

        /*
        * int, long, double 등의 기본값에는 전용 each reduce 가 제공되므로 reduceValuesToInt 등과 같은 메소드를 이용하면
        * 박싱 작업을 할 필요가 없고 효율적으로 작업을 처리할 수 있다.
        * */
        Optional<Long> maxValue =
                Optional.ofNullable(map.reduceValues(parallelismThreshold, Long::max));
    }
}
