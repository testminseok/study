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
        // 이 패턴은 위의 두가지 DSL 형식의 장점을 더한다.
        // 하지만 많은 설정 코드가 필요하며 DSL 자체가 자바 8의 람다 표현식 문법에 의한 잡음의 영향을 많이 받는다는것이 단점이다.
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

        Order order4 = MixedBuilder.forCustomer(
                "BigBank", // 최상위 수준 주문의 속성을 지정하는 중첩 함수
                MixedBuilder.buy(
                        t -> t.quantity(80) // 한개의 주문을 만드는 람다 표현식
                                .stock("IBM") // 거래 객체를 만드는 람다 표현식의 바디의 메소드 체인
                                .on("NYSE")
                                .at(125.00)),
                MixedBuilder.sell(
                        t -> t.quantity(50)
                                .stock("GOOGLE")
                                .on("NASDAQ")
                                .at(125.00))
        );
    }
}
