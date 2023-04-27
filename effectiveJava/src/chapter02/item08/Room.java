package chapter02.item08;

import java.lang.ref.Cleaner;

/*
* cleaner(자바 8까지는 finalizer)는 안전망 역활이나 중요하지 않은 네이티브 자원 회수용으로만 사용하자.
* 물론 이런 경우라도 불확실성과 성능 저하에 주의해야한다.
* */
public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    private final State state;

    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        this.state = new State(numJunkPiles);
        this.cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }

    /*
    * State 인스턴스는 절대로 Room 인스턴스를 참조해서는 안된다.
    * 참조할 경우 두 객체는 서로 참조하게 되고, GC가 수거할 수 없게 된다.
    * */
    private static class State implements Runnable {
        int numJunkPiles;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("쓱싹 쓱싹 재미있는 청소~");
            numJunkPiles = 0;
        }
    }
}
