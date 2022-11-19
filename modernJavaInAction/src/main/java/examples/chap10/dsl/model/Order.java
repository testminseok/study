package examples.chap10.dsl.model;

import java.util.ArrayList;
import java.util.List;

public record Order(String customer, List<Trade> trades) {

    public Order(String customer) {
        this(customer, new ArrayList<>());
    }

    public void addTrade(Trade trade) {
        trades.add(trade);
    }

    public double getValue() {
        return trades.stream().mapToDouble(Trade::getValue).sum();
    }
}
