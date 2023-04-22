package chapter02.item03;

/**
 * 열거타입 방식의 싱글턴
 * - 직렬화할 수 있고, 리플렉션 공격에도 안전하다.
 * - 원소가 하나뿐인 열거타입이 싱글턴을 만드는 가장 좋은 방법이다.
 * - 단, 만들려는 싱글턴이 Enum 외의 클래스를 상속해야 한다면 이 방법은 사용할 수 없다.
 * */
public enum Mercury {
    INSTANCE;

    public void leaveTheBuilding() { }
}
