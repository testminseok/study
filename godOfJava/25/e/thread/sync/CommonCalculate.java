package e.thread.sync;

public class CommonCalculate {
    private int amount;
    private int interest;

    /*
    * 일반적으로 특정 객체를 선언해 look 으로 사용한다.
    * 해당 객체는 synchronized 키워드가 붙은 블록에 스레드가 이미 접근해 있다면 다른 쓰레드가 사용하지 못하게한다.
    * */
    private Object amountLook = new Object();
    private Object interestLook = new Object();

    public CommonCalculate() {
        amount = 0;
    }

    public void addInterest(int value) {
        synchronized (interestLook) {
            interest += value;
        }
    }

//    public synchronized void plus(int value) {
//        amount += value;
//    }

    public void plus(int value) {
        synchronized (amountLook) {
            amount += value;
        }
    }

//    public synchronized void minus(int value) {
//        amount -= value;
//    }

    public void minus(int value) {
        synchronized (amountLook) {
            amount -= value;
        }
    }

    public int getAmount() {
        return amount;
    }
}
