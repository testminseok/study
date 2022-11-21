package examples.chap10.dsl;

import examples.chap10.dsl.model.Order;
import examples.chap10.dsl.model.Stock;
import examples.chap10.dsl.model.Trade;

import static examples.chap10.LambdaOrderBuilder.order;
import static examples.chap10.dsl.MethodChainingOrderBuilder.forCustomer;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("BigBank");

        Stock stock = new Stock("IBM", "NYSE");
        Trade trade = new Trade(Trade.Type.BUY, stock, 80, 125.00);
        order.addTrade(trade);

        Stock stock2 = new Stock("GOOGLE", "NASDAQ");
        Trade trade2 = new Trade(Trade.Type.BUY, stock2, 50, 375.00);
        order.addTrade(trade2);

        // from builder
        Order order2 = forCustomer("BigBank")
                .buy(80)
                .stock("IBM")
                .on("NYSE")
                .at(125.00)
                .sell(50)
                .stock("GOOGLE")
                .on("NASDAQ")
                .at(375.00)
                .build();

        // from functional sequence
        Order order3 = order(o -> {
            o.forCustomer("BigBank");
            o.buy(t -> {
                t.quantity(80);
                t.price(125.00);
                t.stock(s -> {
                    s.symbol("IBM");
                    s.market("NYSE");
                });
            });
            o.sell(t -> {
                t.quantity(50);
                t.price(375.00);
                t.stock(s -> {
                    s.symbol("GOOGLE");
                    s.market("NASDAQ");
                });
            });
        });
    }
}
