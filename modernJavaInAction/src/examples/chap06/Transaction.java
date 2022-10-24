package examples.chap06;

public record Transaction(Currency currency, double value) {
    @Override
    public String toString() {
        return "Transaction{" +
                "currency=" + currency +
                ", value=" + value +
                '}';
    }
}
