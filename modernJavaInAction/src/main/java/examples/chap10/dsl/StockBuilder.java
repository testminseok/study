package examples.chap10.dsl;

import examples.chap10.dsl.model.Stock;
import examples.chap10.dsl.model.Trade;

public class StockBuilder {

    private final MethodChainingOrderBuilder builder;
    private final Trade trade;

    private final Stock stock;

    public StockBuilder(MethodChainingOrderBuilder builder, Trade trade, String symbol) {
        this.builder = builder;
        this.trade = trade;
        this.stock = new Stock(symbol);
    }

    public TradeBuilderWithStock on(String market) {
        stock.setMarket(market);
        trade.setStock(stock);
        return new TradeBuilderWithStock(builder, trade);
    }
}
