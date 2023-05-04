package chapter02.item14;

import java.util.Comparator;

public class PhoneNumber implements Comparable<PhoneNumber> {

    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);

    private static final Comparator<Object> hashCodeOrder = new Comparator<>() {
        @Override
        public int compare(Object o1, Object o2) {
            return Integer.compare(o1.hashCode(), o2.hashCode());
        }
    };
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
    public int compareTo(PhoneNumber o) {
        // 자바 7에서 부터는 실수가 아닌 정수 타입도 박싱 클래스의 정적메서드인 compare 를 사용하자.
//        int result = Short.compare(areaCode, o.areaCode);
//        if (result == 0) {
//            result = Short.compare(prefix, o.prefix);
//            if (result == 0) {
//                result = Short.compare(lineNum, o.lineNum);
//            }
//        }
//
//        return result;
        return COMPARATOR.compare(this, o);
    }
}
