package examples.chap09;

public class OnlineBankingMain {
    public static void main(String[] args) {
        new OnlineBanking() {
            @Override
            void makeCustomerHappy(Customer c) {
                System.out.println(c);
            }
        }.processCustomer(1337);
        new OnlineBankingLambda().processCustomer(1337, System.out::println);
    }
}
