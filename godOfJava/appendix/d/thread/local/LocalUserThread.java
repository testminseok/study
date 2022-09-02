package d.thread.local;

public class LocalUserThread extends Thread {
    @Override
    public void run() {
        int value = ThreadLocalSample.generateNumber();
        System.out.println(getName() + " LocalUserThread value = " + value);

        OtherLogic otherLogic = new OtherLogic();
        otherLogic.printMyNumber();

        ThreadLocalSample.remove();
    }
}
