package d.util;

import java.math.BigDecimal;

public class BigDecimalSample {
    public static void main(String[] args) {
        BigDecimalSample sample = new BigDecimalSample();
        sample.normalDoubleCalc();
        sample.bigDecimalCalc();
    }

    private void bigDecimalCalc() {
        /*
        * BigDecimal  클래스의 생성자로 문자열 값을 전달해 주는것이 좋다.
        * 또한 정수형 계산만 필요하다면 BigInteger 를 사용하면된다.
        * */
        BigDecimal value = new BigDecimal("1.0");
        BigDecimal addValue = new BigDecimal("0.1");

        for (int i = 0; i < 10; i++) {
            value = value.add(addValue);

            System.out.println(value);
        }
    }

    private void normalDoubleCalc() {
        /*
        * Java 에서는 IEEE 표준을 따른다. 그러므로, 소수점 결과는 정확하지 않을 수 있다.
        * float, double 는 근사치를 제공할 뿐이지 정확하지 않다.
        * */
        double value = 1.0;
        for (int i = 0; i < 10; i++) {
            value += 0.1;
            System.out.println(value);
        }
    }
}
