package chapter11.item81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * - wait 와 notify 는 올바르게 사용하기가 아주 까다로우니 고수준 동시성 유틸리티를 사용하자.
 * - 동시성 컬렉션에서 동시성을 무력화하는 건 불가능하며, 외부에서 락을 추가로 사용하면 오히려 속도가 느려진다.
 * - Collections.synchronizedMap 보다는 ConcurrentHashMap 을 사용하는게 훨씬 좋다.
 * - 시간 간격을 잴 때는 항상 System.currentTimeMillis 보다 System.nanoTime 을 사용하라.
 * - wait 메서드를 사용할 때는 반드시 대기 반복문(wait loop) 관용구를 사용하라. 반복문 밖에서는 절대 호출하지 말자.
 *
 * wait 와 notify 를 직접 사용하는 것을 동시성 '어셈블리 언어'로 프로그래밍하는 것에 비유할 수 있다.
 * 반면 java.util.concurrent 는 고수준 언어에 비유할 수 있다.
 * 코드를 새로 작성한다면 wait 와 notify 를 쓸 이유가 거의 없다.
 * 이들을 사용하려는 레거시 코드를 유지보수해야 한다면 wait 는 항상 표준 관용구에 따라 while 문 안에서만 호출하도록 하자.
 * 일반적으로 notify 보다 notifyAll 을 사용해야 한다.
 * 혹시라도 notify 를 사용한다면 응답 불가 상태에 빠지지 않도록 각별히 주의하자.
 * */
public class UsingConcurrentUtility {
    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    /**
     * ConcurrentHashMap 은 get 같은 검색 기능에만 최적화되어 있다.
     * 따라서, get 을 먼저 호출하여 필요할 때만 putIfAbsent 를 호출하는 것이 성능에 좋다.
     * */
    public static String intern(String s) {
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null) {
                result = s;
            }
        }
        return result;
    }

    /**
     * 동시 실행 시간을 재는 간단한 프레임워크
     * */
    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done  = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                // 타이머에게 준비를 마쳤음을 알린다.
                ready.countDown();
                try {
                    // 모든 작업자 스레드가 준비될 때까지 기다린다.
                    start.await();
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // 타이머에게 작업을 마쳤음을 알린다.
                    done.countDown();
                }
            });
        }

        ready.await(); // 모든 작업자가 준비될 때까지 기다린다.
        long startNanos = System.nanoTime();
        start.countDown(); // 작업자들을 깨운다.
        done.await(); // 모든 작업자가 일을 끝마치기를 기다린다.
        return System.nanoTime() - startNanos;
    }
}
