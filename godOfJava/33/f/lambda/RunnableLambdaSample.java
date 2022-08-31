package f.lambda;

public class RunnableLambdaSample {
    public static void main(String[] args) {
        RunnableLambdaSample sample = new RunnableLambdaSample();
        sample.runCommonThread();
    }

    private void runCommonThread() {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
