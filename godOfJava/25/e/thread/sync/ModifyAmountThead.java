package e.thread.sync;

public class ModifyAmountThead extends Thread {
    private CommonCalculate calculate;
    private boolean addFlag;

    public ModifyAmountThead(CommonCalculate calculate, boolean addFlag) {
        this.calculate = calculate;
        this.addFlag = addFlag;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (addFlag) {
                calculate.plus(1);
            } else {
                calculate.minus(1);
            }
        }
    }
}
