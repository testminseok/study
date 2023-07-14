package chapter11.item84;

/**
 * - 정확성이나 성능이 스레드 스케줄러에 따라 달라지는 프로그램이라면 다른 플랫폼에 이식하기 어렵다.
 * - 스레드는 당장 처리해야 할 작업이 없다면 실행되서는 안된다.
 * - Thread.yield 를 써서 문제를 고쳐보려는 유혹을 떨쳐내자.
 * - Thread.yield 는 테스트할 수단도 없다.
 *
 * 프로그램의 동작을 스레드 스케줄러에 기대지 말자. 견고성과 이식성을 모두 해치는 행위다.
 * 같은 이유로, Thread.yield 와 스레드 우선순위에 의존해서도 안된다.
 * 이 기능들은 스레드 스케줄러에 제공하는 힌트일 뿐이다. 스레드 우선순위는 이미 잘 동작하는 프로그램의 서비스 품질을
 * 높이기 위해 드물게 쓰일 수오는 있지만, 간신히 동작하는 프로그램을 '고치는 용도'로 사용해서는 안된다.
 */
public class SlowCountDownLatch {
    private int count;

    public SlowCountDownLatch(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(count + " < 0");
        }
        this.count = count;
    }

    public void await() {
        while (true) {
            synchronized (this) {
                if (count == 0) {
                    return;
                }
            }
        }
    }

    public synchronized void countDown() {
        if (count != 0) {
            count--;
        }
    }
}
