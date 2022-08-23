package e.thread.sync;

public class RunSync {
    public static void main(String[] args) {
        RunSync runSync = new RunSync();
        for (int i = 0; i < 5; i++) {
            runSync.runCommonCalculate();
        }
    }

    public void runCommonCalculate() {
        /*
            calculate 객체에 plus() 메소드에 synchronized 키워드를 붙이지 않으면
            plus() 메소드에 여러 쓰레드가 동시에 접근하여 다른 쓰레드가 온전히 수행이 완료되기 전에 값을 수정한다.
        */
        CommonCalculate calculate = new CommonCalculate();
        ModifyAmountThead thread1 = new ModifyAmountThead(calculate, true);
        ModifyAmountThead thread2 = new ModifyAmountThead(calculate, true);

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // Thread 가 완전히 종료될때까지 기다린다.
            thread2.join();

            System.out.println("Final value is " + calculate.getAmount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
