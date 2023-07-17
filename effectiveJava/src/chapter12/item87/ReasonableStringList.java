package chapter12.item87;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 해당 객체의 논리적 상태와 무관한 필드라고 확신할 때만 transient 한정자를 생략해야 한다.
 *
 * 객체의 전체 상태를 읽는 메서드에 적용해야 하는 동기화 메커니즘을 직렬화에도 사용해야한다.
 * 따라서 예컨대 모든 메서드를 synchronized 로 선언하여 스레드 안전하게 만든 객체에서 기본직렬화를 사용하려면
 * writeObject 도 synchronized 로 선언해야 한다.
 * ex) private synchronized void writeObject(ObjectOutputStream s) throws IOException
 *
 * 어떤 직렬화 형태를 택하든 직렬화 가능 클래스 모두에 직렬 버전 UID를 명시적으로 부여하자.
 * ex) private static final long serialVersionUID = 123456789L;
 *
 * 구버전으로 직렬화된 인스턴스들과의 호환성을 끊으려는 경우를 제외하고는 직렬 버전 UID 를 절대 수정하지말자.
 *
 * 정리
 * 클래스를 직렬화하기로 했다면 어떤 직렬화 형태를 사용할지 심사숙고 해야한다.
 * 자바의 기본 직렬화 형태는 객체를 직렬화한 결과가 해당 객체의 논리적 표현에 부합할 때만 사용하고,
 * 그렇지 않으면 객체를 적절히 설명하는 커스텀 직렬화 형태를 고안하라.
 * 직렬화 형태도 공개 메서드를 설계할 떄에 준하는 시간을 들여 설계해야 한다.
 * 한번 공개된 메서드는 향후 릴리스에서 제거할 수 없듯이, 직결화 형태에 포함된 필드도 마음대로 제거할 수 없다.
 * 직렬화 호환성을 유지하기 위해 영원히 지원해야 하는 것이다.
 * 잘못된 직렬화 형태를 선택하면 해당 클래스의 복잡성과 성능에 영구히 부정적인 영향을 남긴다.
 * */
public class ReasonableStringList implements Serializable {
    private transient int size = 0;
    private transient Entry head = null;

    // 이제는 직렬화되지 않는다.
    private static class Entry {
        String data;
        Entry next;
        Entry previous;
    }

    // 지정한 문자열을 이 리스트에 추가한다.
    public final void add(String s) {
    }

    /**
     * 이 {@code StringList} 인스턴스를 직렬화한다.
     *
     * @serialData 이 리스트의 크기(포함된 문자열의 개수)를 기록한 후
     * ({@code int}), 이어서 모든 원소를(각각은 {@code String}) 순서대로 기록한다.
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        // 모든 원소를 올바른 순서로 기록한다.
        for (Entry e = head; e != null; e = e.next) {
            s.writeObject(e.data);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        // 모든 원소를 읽어 이 리스트에 삽입한다.
        for (int i = 0; i < numElements; i++) {
            add((String) s.readObject());
        }
    }
}
