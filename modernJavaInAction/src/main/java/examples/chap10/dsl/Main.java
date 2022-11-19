package examples.chap10.dsl;

import examples.chap10.dsl.model.Order;
import examples.chap10.dsl.model.Stock;
import examples.chap10.dsl.model.Trade;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("BigBank");

        Stock stock = new Stock("IBM", "NYSE");
        Trade trade = new Trade(Trade.Type.BUY, stock, 80, 125.00);
        order.addTrade(trade);

        Stock stock2 = new Stock("GOOGLE", "NASDAQ");
        Trade trade2 = new Trade(Trade.Type.BUY, stock2, 50, 375.00);
        order.addTrade(trade2);

    }
}
