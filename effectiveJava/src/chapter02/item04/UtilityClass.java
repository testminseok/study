package chapter02.item04;

public class UtilityClass {

    /*
    * 기본 생성자가 만들어지는 것을 막는다 (인스턴스화 방지)
    * - 생성자를 명시적으로 private 으로 선언한다.
    * - private 생성자는 클래스 내부에서도 명시적으로 호출할 수 없다.
    * - private 생성자는 하위 클래스를 만들 수 없게 막는다.
    * */
    private UtilityClass() {
        throw new AssertionError();
    }
}
