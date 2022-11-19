package examples.chap10.dsl.model;

public record Trade(Type type, Stock stock, int quantity, double price) {
    public enum Type {BUY, SELL}

    public double getValue() {
        return quantity * price;
    }
}
