package chapter02.item49;

import java.math.BigInteger;
import java.util.Objects;

/**
 * 메서드나 생성자를 작성할 때면 그 매개변수들에 어떤 제약이 있을지 생각해야 한다.
 * 그 제약들을 문서화하고 메서드 코드 시작 부분에서 명시적으로 검사해야 한다. 이런 습관을 반드시 기르도록 하자.
 * 그 노력은 유효성 검사가 실제 오류를 처음 걸러낼 때 충분히 보상받을 것이다.
 * */
public class MethodParametersValid {

    /**
     * (현재 값 mod m) 값을 반환한다.
     * 이 메서드는 항상 음이 아닌 BigInteger 를 반환한다는 점에서 remainder 메서드와 다르다.
     *
     * @param m 계수(양수여야 한다.)
     * @return 현재 값 mod m
     * @throws ArithmeticException m 이 0 보다 작거나 같으면 발생한다.
     * */
    public BigInteger mode(BigInteger m) {
        Objects.requireNonNull(m, "계수(m)는 null이 아니어야 합니다.");
        if (m.signum() <= 0) {
            throw new ArithmeticException("계수(m)는 양수여야 합니다. " + m);
        }
        // ... code
        return BigInteger.ZERO;
    }

    private static void sort(long[] a, int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
        // ... code
    }
}
