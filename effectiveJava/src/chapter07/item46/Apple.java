package chapter02.item46;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Apple {
    FUJI, PIPPIN, GRANNY_SMITH;

    // toMap 수집기를 사용하여 문자열을 열거 타입 상수에 매핑한다.
    private static final Map<String, Apple> stringToEnum =
            Stream.of(values()).collect(toMap(Object::toString, e -> e));

    public static Apple fromString(String symbol) {
        return stringToEnum.get(symbol);
    }
}
