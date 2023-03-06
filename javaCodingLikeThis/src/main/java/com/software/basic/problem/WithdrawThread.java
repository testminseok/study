package com.software.basic.problem;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 7-4 과도한 스레드 동기화는 병목현상을 유발한다.
 */
public class WithdrawThread extends Thread {
    private int withdraw;
    private int index;

    public WithdrawThread(int index, int withdraw) {
        this.index = index;
        this.withdraw = withdraw;
    }

    @Override
    public void run() {
        // 예금 한도를 초과하는 금액은 인출하지 못하도록 방지
        if (EmptySynchronizedBlockExample.saving - withdraw >= 0) {
            try {
                // 출금과 프로세스의 소요 시간을 가정한 지연시간
                SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
                int sleepTime = random.nextInt(400);
                Thread.sleep(sleepTime);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 예금을 인출
            EmptySynchronizedBlockExample.saving -= withdraw;
            System.out.printf("Thread[%d] 잔액 : %d (출금 : %d) \n", index, EmptySynchronizedBlockExample.saving, withdraw);
        } else {
            System.out.printf("Thread[%d] 잔액이 부족합니다. [%d] (출금 요청 : %d)\n", index, EmptySynchronizedBlockExample.saving, withdraw);
        }
    }
}
