package examples.chap09;

import java.util.function.Consumer;

public class OnlineBankingLambda {
    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

    public record Customer(String name) {}

    // 더미 Database 클래스
    private static class Database {

        static OnlineBankingLambda.Customer getCustomerWithId(int id) {
            return new OnlineBankingLambda.Customer("testmin");
        }

    }
}
