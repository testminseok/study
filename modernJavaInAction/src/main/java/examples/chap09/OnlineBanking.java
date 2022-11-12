package examples.chap09;

abstract class OnlineBanking {
    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);

    // 더미 Customer 클래스
    public record Customer(String name) {}

    // 더미 Database 클래스
    private static class Database {

        static Customer getCustomerWithId(int id) {
            return new Customer("testmin");
        }

    }
}
