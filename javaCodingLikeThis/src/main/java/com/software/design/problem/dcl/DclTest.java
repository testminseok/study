package com.software.design.problem.dcl;

public class DclTest {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                // 첫번째 인스턴스 호출
                DclExample.getInstance().printStatus();
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                // 두번째 인스턴스 호출
                DclExample.getInstance().printStatus();
            }
        };

        thread.start();
        thread2.start();
    }
}
