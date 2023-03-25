package com.software.design.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 9-10 메소드 단위의 스레드 동기화에 주의한다.
 * - AvoidSynchronizedAtMethodLevel : 메소드에 synchronized 키워드를 사용해 스레드 동기화를 설정하면 수정을 권고한다.
 *                                    메소드 내에 어떠한 기능도 없고 단지 공유 자원에 접근하는 기능만 있다면 메소드 단위의 스레드 동기화를 사용할 수 있다.
 *                                    그러나, 그렇지 않고 다른 코드가 있다면 메소드 수준에 동기화는 새 코드가 메소드에 추가될 때 문제가 될 수 있다.
 *                                    블록 수준 동기화는 동기화가 필요한 코드만 동기화 영역으로 처리하여 메소드 전체를 동기화하는 것보다 효율적이다.
 */
public class AvoidSynchronizedExample {

    private List<Map<String, Object>> userList = new ArrayList<>();

    /**
     * 메소드 전체가 스레드 동기화 영역으로 설정되어
     * 메소드의 모든 코드가 실행돼야 동기화 영역에서 벗어날 수 잇따.
     * */
    public void adUser(Map<String, Object> user) throws InterruptedException {
        // 기타 프로세스가 진행되는 시간을 가정해 1초로 설정
        Thread.sleep(1000);

        // 실제 공유 자원에 접근하는 부분
        synchronized (this) {
            userList.add(user);
        }
    }

}
