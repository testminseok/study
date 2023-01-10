package examples.chap19.patternmatching;

public class Number extends Expr {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                '}';
    }
}
