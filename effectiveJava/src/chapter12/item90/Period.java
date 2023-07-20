package chapter12.item90;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Date start;
    private final Date end;

    /**
     * @param start 시작 시각
     * @param end 종료 시각. 시작 시각보다 뒤여야 한다.
     * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생한다.
     * @throws NullPointerException start 나 end 가 null 이면 발생한다.
     * */
    public Period(Date start, Date end) {
        // 매개변수의 방어적 복사본을 만든다.
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        /*
        * 매개변수의 유효성을 검사하기 전에 방어적 복사본을 만들고, 이 복사본으로 유효성을 검사한 점에 주목하자.
        * 멀티스레딩 환경이라면 원본 객체의 유효성을 검사한 후 복사본을 만드는 그 찰나의 취약한 순간에 다른 스레드가 원본 객체를
        * 수정할 위험이 있기 때문이다.
        * */
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
        }
    }

    public Date start() {
        // 필드의 방어적 복사본을 반환한다.
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return "Period{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    private static class SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final Date start;
        private final Date end;

        public SerializationProxy(Period period) {
            this.start = period.start;
            this.end = period.end;
        }

        private Object readResolve() {
            return new Period(start, end);
        }
    }

    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        throw new InvalidObjectException("프록시가 필요합니다.");
    }
}
