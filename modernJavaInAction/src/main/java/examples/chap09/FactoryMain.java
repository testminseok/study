package examples.chap09;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/*
* 팩토리 디자인 패턴
* */
public class FactoryMain {

    static final Map<String, Supplier<Product>> productMap = new HashMap<>() {{
        put("loan", Loan::new);
        put("stock", Stock::new);
        put("bond", Bond::new);
    }};

    public static void main(String[] args) {
        Product loan = ProductFactory.createProduct("loan");

        // from lambda
        Supplier<Product> stockSupplier = Stock::new;
        Product stock = stockSupplier.get();

        // 생성자의 인수가 많아지는 경우에는 이 기법을 사용하기 어렵다. 인수를 받을 수 있는 함수형 인터페이스를 생성해야한다.
        Product bond = ProductFactory.createProductByLambda("bond");
    }

    static class ProductFactory {
        public static Product createProduct(String name) {
            switch (name) {
                case "loan":
                    return new Loan();
                case "stock":
                    return new Stock();
                case "bond":
                    return new Bond();
                default:
                    throw new RuntimeException("No Such Product " + name);
            }
        }

        public static Product createProductByLambda(String name) {
            Supplier<Product> productSupplier = productMap.get(name);

            if (productSupplier != null) {
                return productSupplier.get();
            }

            throw new IllegalArgumentException("No such product " + name);
        }
    }

    private interface Product {}
    private static class Loan implements Product {}
    private static class Stock implements Product {}
    private static class Bond implements Product {}
}
