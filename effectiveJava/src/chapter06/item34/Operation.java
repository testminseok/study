package chapter02.item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private static final Map<String, Operation> stringToEnum =
            Stream.of(values())
                    .collect(Collectors.toMap(Object::toString, e -> e));
    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    // 상수별 메서드 구현
    public abstract double apply(double x, double y);
    public double apply2(double x, double y) {
        switch (this) {
            case PLUS: return x + y;
            case MINUS: return x - y;
            case TIMES: return x * y;
            case DIVIDE: return x / y;
        }

        throw new AssertionError("알 수 없는 연산: " + this);
    }

    // switch 문을 이용해 원래 열거 타입에 없는 기능을 수행한다.
    public static Operation inverse(Operation op) {
        switch (op) {
            case PLUS: return Operation.MINUS;
            case MINUS: return Operation.PLUS;
            case TIMES: return Operation.DIVIDE;
            case DIVIDE: return Operation.TIMES;
        }

        throw new AssertionError("알 수 없는 연산: " + op);
    }

    @Override
    public String toString() {
        return symbol;
    }

    /*
    * 지정한 문자열에 해당하는 Operation 을 (존재한다면) 반환한다.
    * toString 을 재정의 하려거든, toString 반환하는 문자열을 해당 열거 타입 상수로 변환해주는
    * fromString 메서드도 함께 제공하는걸 고려해보자.
    * */
    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }
}
