package com.software.design.solution.dcl;

/**
 * 9-7 스레드 동기화는 중복해서 하지 않는다.
 * - NonThreadSafeSingleton :
 *
 */
public class DclExample {
    private static DclExample instance;
    private String msg = "초기화 이전";

    private DclExample() {}

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static DclExample getInstance() {
        System.out.println("인스턴스 생성 시작");

        synchronized (DclExample.class) {
            if (instance == null) {
                instance = new DclExample();
                System.out.println("다음 아이디로 인스턴스가 생성됨 : " + instance);
                instance.setMsg("초기화 완료");
            }

        }

        return instance;
    }

    public void printStatus() {
        System.out.println(msg);
    }
}
