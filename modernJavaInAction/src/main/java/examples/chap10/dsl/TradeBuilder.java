package examples.chap10.dsl;

import examples.chap10.dsl.model.Trade;

public class TradeBuilder {
    private final MethodChainingOrderBuilder builder;
    private Trade trade;

    public TradeBuilder(MethodChainingOrderBuilder builder, Trade.Type type, int quantity) {
        this.builder = builder;
        this.trade = new Trade();
        trade.setType(type);
        trade.setQuantity(quantity);
    }

    public StockBuilder stock(String symbol) {
        return new StockBuilder(builder, trade, symbol);
    }
}
