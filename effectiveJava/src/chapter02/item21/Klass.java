package chapter02.item21;

/*
* 기존 인터페이스에 디폴트 메서드를 추가하는 일은 꼭필요한 경우가 아니라면 피해야한다.
* 구현체는 해당 메서드의 유무를 알지 못한체 해당 메서드를 제공하기 때문이다.
* 반면, 새로운 인터페이스를 만드는 경우라면 표준적인 메서드 구현을 제공하는 데 아주 유용한수다이며,
* 그 인터페이스를 더 쉽게 구현해 활용할 수 있게끔 해준다.
*
* 핵심은 디폴트 메서드라는 도구가 생겼더라도 인터페이스를 설계할 떄는 여전히 세심한 주의를 기울여야한다.
* 또한 새 인터페이스를 작성할때는 릴리스 전에 반드시 테스트를 거쳐야한다. 서로 다른 방식으로 최소한 세 가지는 구현해봐야한다.
* */
public class Klass implements DefaultMethodInterface {

    public static void main(String[] args) {
        Klass klass = new Klass();
        // 버전 1에서는 인터페이스에 정의된 versionOneMethod() 메서드만 호출할 수 있었다.
        klass.versionOneMethod();

        // 그러나 버전 2에서는 구현체는 원하지 않았지만 인터페이스에 삽입된 버전2의 메서드를 호출할 수 있게 되었다.
        klass.versionTwoMethod();
    }
    @Override
    public void versionOneMethod() {
        System.out.println("versionOneMethod");
    }
}
