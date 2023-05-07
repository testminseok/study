package chapter02.item17;

import java.util.Objects;

/*
* 불변 객체는 근본적으로 스레드 안전하여 따로 동기화할 필요가 없다.
* */
public final class Complex {

    /*
    * 불변 객체는 안심하고 공유할 수 있다.
    * 따라서 불변 클래스라면 한번 만든 인스턴스를 최대한 활용하기를 권장한다.
    * 가장 쉬운 재활용 방법은 자주 쓰이는 값들을 상수로 제공하는것이다.
    * */
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);
    private final double re;
    private final double im;

    /*
    * 클래스가 불변임을 보장하려면 자신을 상속하지 못하게 해야한다.
    * 그 방법 중 가장 쉬운 방법은 final 클래스로 선언하는 것이지만,
    * 더 유연한 방법은 모든 생성자를 private 혹은 package-private 으로 만들고 public 정적 팩터리를 제공하는 방법이다.
    * */
    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complex)) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.re, re) == 0 && Double.compare(complex.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    @Override
    public String toString() {
        return "Complex{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }
}
