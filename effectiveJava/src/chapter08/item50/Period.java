package chapter02.item50;

import java.util.Date;

/*
* 클래스가 클라이언트로부터 받는 혹은 클라이언트로 반환하는 구성요소가 가변이라면 그 요소는 반드시 방어적으로 복사해야 한다.
* 복사 비용이 너무 크거나 클라이언트가 그 요소를 잘못 수정할 일이 없음을 신뢰한다면 방어적 복사를 수행하는 대신 해당 구성요소를
* 수정했을 때의 책임이 클라이언트에 있음을 문서에 명시하자.
* */
public class Period {
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

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period period = new Period(start, end);
        end.setYear(78); // period 의 내부를 수정했다.
        System.out.println(period.end());

        Date start2 = new Date();
        Date end2 = new Date();
        Period period2 = new Period(start2, end2);
        period2.end().setYear(78); // period 의 내부를 수정했다.
        System.out.println(period2.end());
    }

    public Date start() {
        // 필드의 방어적 복사본을 반환한다.
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    // 나머지 코드 생략
}
