package com.software.basic.problem;

/**
 * 7-4 과도한 스레드 동기화는 병목현상을 유발한다.
 * - EmptySynchronizedBlock : 비어있는 동기화 구역이 있을경우 수정을 권고한다. (Deprecated EmptyControlStatement병합됨)
 * - EmptyControlStatement : 본문이 비어있는 제어문과 빈 초기화 블럭이 있을경우 수정을 권고한다.
 */
public class EmptySynchronizedBlockExample {
    public static int saving = 9000;

    public static void main(String[] args) {
        /*
        * 동기화를 이용하면 자원에 여러 스레드가 동시에 접근하는 상황에서도 충돌을 방지할 수 있지만 모든 요청이
        * 하나의 통로로 처리된다. 그러한 상황에서는 병목현상이 발생할 수 있다.
        * 때문에 동기화 구역은 필연적으로 병목현상을 만들어내므로 매우 신중히 결정해야 한다.
        * */

        // 예금을 동시에 인출할 스레드 생성
        WithdrawThread thread0 = new WithdrawThread(0, 1000);
        WithdrawThread thread1 = new WithdrawThread(1, 2000);
        WithdrawThread thread2 = new WithdrawThread(2, 3000);
        WithdrawThread thread3 = new WithdrawThread(3, 4000);
        WithdrawThread thread4 = new WithdrawThread(4, 5000);

        // 스레드 실행
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public void badCode() {
        synchronized (this) {

        }
    }
}
