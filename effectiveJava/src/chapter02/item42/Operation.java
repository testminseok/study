package chapter02.item42;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
    /*
    * 메서드나 클래스와 달리, 람다는 이름이 없고 문서화도 못 한다. 따라서 코드 자체로 동작이 명확히 설명되지 않거나
    * 코드 줄 수가 많아지면 람다를 쓰지 말아야 한다. 람다는 한 줄일 때 가장 좋고, 세 줄을 넘어가면 쓰지 말아야 한다.
    * */
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
