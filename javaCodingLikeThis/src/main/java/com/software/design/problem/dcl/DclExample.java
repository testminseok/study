package com.software.design.problem.dcl;

/**
 * 9-7 스레드 동기화는 중복해서 하지 않는다.
 * - NonThreadSafeSingleton : 동기화 되지 않은 블럭에서 Singleton 객체를 사용할 경우 수정을 권고한다.
 *                            - ThreadSafe 하지 않은 Singleton 은 잘못된 상태변경을 할 수 있다.
 *                            - 가능한경우 직접 인스턴스화 하여 정적 싱글톤을 제거하거나 수정 가능한 전체 메소드를 동기화 해야한다.
 *                              또는 initialize-on-demand holder class 를 사용한다.
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

        if (instance == null) {
            synchronized (DclExample.class) {
                if (instance == null) {
                    instance = new DclExample();
                    System.out.println("다음 아이디로 인스턴스가 생성됨 : " + instance);
                    instance.setMsg("초기화 완료");
                }
            }
        }

        return instance;
    }

    public void printStatus() {
        System.out.println(msg);
    }
}
