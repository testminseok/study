package chapter12.item88;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 정리
 * readObject 메서드를 작성할 때는 언제나 pulbic 생성자를 작성하는 자세로 임해야 한다.
 * readObject 는 어떤 바이트 스트림이 넘어오더라도 유효한 인스턴스를 만들어내야한다.
 * 바이트 스트림이 진짜 직렬화된 인스턴스라고 가정해서는 안 된다.
 * 이번 아이템에서는 기본 직렬화 형태를 사용한 클래스를 예로 들었지만 커스텀 직렬화를 사용하더라도 모든 문제가 그대로 발생할 수 있다.
 * 이어서 안전한 readObject 메서드를 작성하는 지침을 요약해보았다.
 *
 * 1. private 이어야 하는 객체 참조 필드는 각 필드가 기리키는 객체를 방어적으로 복사하라. 불변 클래스 내의 가변 요소가 여기 속한다.
 * 2. 모든 불변식을 검사하여 어긋나는 게 발견되면 InvalidObjectException 을 던진다.
 *    방어적 복사 다음에는 반드시 불변식 검사가 뒤따라야 한다.
 * 3. 역직렬화 후 객체 그래프 전체의 유효성을 검사해야 한다면 ObjectInputValidation 인터페이스를 사용하라.
 * 4. 직접적이든 간접적이든, 재정의할 수 있는 메서드는 호출하지 말자.
 * */
public class Period implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date start;
    private Date end;

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

    /*
    * 객체를 역질렬화할 때는 클라이언트가 소유해서는 안되는 객체 참조를 갖는 필드를 모두 반드시 방어적으로 복사해야한다.
    * */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        // 가변 요소를 방어적으로 복사한다.
        start = new Date(start.getTime());
        end = new Date(end.getTime());

        // 불변식을 만족하는지 검사한다.
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
        }
    }

    @Override
    public String toString() {
        return "Period{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
