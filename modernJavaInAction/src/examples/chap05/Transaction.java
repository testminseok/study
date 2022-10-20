package examples.chap05;

public record Transaction(Trader trader, int year, int value) {

    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "value:" + this.value + "}";
    }
}
