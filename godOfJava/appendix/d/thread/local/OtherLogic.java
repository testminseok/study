package d.thread.local;

public class OtherLogic {
    public void printMyNumber() {
        System.out.println(Thread.currentThread().getName() + " OtherLogin value = " + ThreadLocalSample.get());
    }
}
