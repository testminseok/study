package examples.chap10.dsl;

import examples.chap10.dsl.model.Order;
import examples.chap10.dsl.model.Tax;

import java.util.function.DoubleUnaryOperator;

public class TaxCalculator {

    private boolean useRegional;
    private boolean useGeneral;
    private boolean useSurcharge;

    // or

    public DoubleUnaryOperator taxFunction = d -> d; // 주문값에 적용된 모든 세금을 계산하는 함수

    public static void main(String[] args) {
        Order order = MixedBuilder.forCustomer(
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

        double value = new TaxCalculator()
                .withTaxRegional()
                .withTaxSurcharge()
                .calculate(order);

        double valueByOperator = new TaxCalculator()
                .with(Tax::regional)
                .with(Tax::surcharge)
                .calculateByOperator(order);
    }

    public TaxCalculator with(DoubleUnaryOperator taxFunction) {
        this.taxFunction =
                this.taxFunction.andThen(taxFunction); // 새로운 세금 계산 함수를 얻어서 인수로 전달된 함수와 현재함수를 합친다.
        return this;
    }

    public double calculateByOperator(Order order) {
        return taxFunction.applyAsDouble(order.getValue()); // 주문의 총 합에 세금 계산 함수를 적용해 최종 주문값을 계산
    }

    public TaxCalculator withTaxRegional() {
        useRegional = true;
        return this;
    }

    public TaxCalculator withTaxGeneral() {
        useGeneral = true;
        return this;
    }

    public TaxCalculator withTaxSurcharge() {
        useSurcharge = true;
        return this;
    }

    public double calculate(Order order) {
        return calculate(order, useRegional, useGeneral, useSurcharge);
    }

    private double calculate(Order order, boolean useRegional, boolean useGeneral, boolean useSurcharge) {
        double value = order.getValue();

        if (useRegional) {
            value = Tax.regional(value);
        }

        if (useGeneral) {
            value = Tax.general(value);
        }

        if (useSurcharge) {
            value = Tax.surcharge(value);
        }

        return value;
    }
}
