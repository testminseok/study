package examples.chap10.dsl.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String customer;

    private List<Trade> trades;

    public Order(String customer) {
        this(customer, new ArrayList<>());
    }

    public Order(String customer, List<Trade> trades) {
        this.customer = customer;
        this.trades = trades;
    }

    public void addTrade(Trade trade) {
        trades.add(trade);
    }

    public double getValue() {
        return trades.stream().mapToDouble(Trade::getValue).sum();
    }
}
