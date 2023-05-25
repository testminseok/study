package chapter02.item35;

public enum Ensemble {
    SOLE(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8), NONET(9), DECTET(10);

    private final int numberOfMusicians;

    Ensemble(int numberOfMusicians) {
        this.numberOfMusicians = numberOfMusicians;
    }

    /*
    * ordinal 을 잘못 사용한 예 - 따라 하지 말 것!
    * 상수 선언 순서를 바꾸는 순간 오작동한다.
    * 또한 , 값을 중간에 비워둘 수도 없다. (상수의 인덱스 별로 인원을 계산하기 떄문에)
    *
    * 해결법 - 열거 타입 상수에 연결된 값은 ordinal 메서드로 얻지 말고, 인스턴스 필드에 저장하자.
    * ordinal 은 대부분의 프로그래머가 쓸 필요가 없으며, EnumSet 과 EnumMap 같은 열거 타입기반의 범용 자료구조에 쓸 목적으로 설계되었다.
    * */
    public int numberOfMusicians() {
        return numberOfMusicians;
//        return ordinal() + 1;
    }
}
