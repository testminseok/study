package examples.chap16;

public enum Money {
    USD(1.0), EUR(1.35387), GBP(1.69715), CAD(.92106), MXN(.07683), DEFAULT(1.35);

    private final double rate;

    Money(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
