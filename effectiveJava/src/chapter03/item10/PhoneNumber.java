package chapter03.item10;

import java.util.Objects;

public class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix = rangeCheck(prefix, 999, "프리픽스");
        this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }

        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        /*
        * 1. == 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.
        * 2. instanceof 연산자를 사용해 입력이 올바른 타입인지 확인한다.
        * 3. 입력을 올바른 타입으로 형변환한다.
        * 4. 입력 객체와 자기 자신의 대응되는 '핵심' 필드들이 모두 일치하는지 하나씩 검사한다.
        *
        * - float 와 double 필드는 각각 정정 메서드인 Float.compare(float, float) 와
        *   Double.compare(double, double) 을 사용해 비교한다.
        * - 배열의 모든 원소가 핵심 필드라면 Arrays.equals 를 사용한다.
        * - 때론 null 도 정상 값으로 취금하는 참조 타입 필드도 있는데,
        *   이런 필드는 정적 메서드인 Object.equals 를 사용해 NPE 를 방지한다.
        *
        * equals 를 다 구현했다면 세가지만 자문해보자. 대칭적인가?,  추이성이 있는가?, 일관적인가?
        * */

        // 1
        if (this == o) return true;

        // 2,3 instanceof 연산자는 이후 형변환이 안전한지를 보장한다.
        if(!(o instanceof PhoneNumber)) {
            return false;
        }

        // 4
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }
}
