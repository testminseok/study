package com.software.basic.problem;

/**
 * 9-3 switch 문의 default 절은 필수다.
 * - SwitchStmtsShouldHaveDefault : switch 문에 default 문이 없을경우 수정을 권고한다.
 */
public class SwitchStmtsShouldHaveDefaultExample {

    private static final int MSG01 = 1;
    private static final int MSG02 = 2;
    private static final int MSG03 = 3;

    public static void main(String[] args) {
        int msg = MSG01;

        badCoode(msg);
    }

    private static void goodCode(int msg) {
        // default 문을 추가함으로 써 정의되지 않은 사용자 메세지를 처리할 수 있다.
        switch (msg) {
            case MSG01:
                showAdminContents();
                break;
            case MSG02:
                showUserContents();
                break;
            case MSG03:
                showGuestContents();
                break;
            default:
                showGuestContents();
                break;
        }
    }

    private static void badCoode(int msg) {
        // 정해진 메세지만 처리할 수 있을 뿐 예외적인 메세지는 처리할 수 없다.
        switch (msg) {
            case MSG01:
                showAdminContents();
                break;
            case MSG02:
                showUserContents();
                break;
            case MSG03:
                showGuestContents();
                break;
        }
    }

    private static void showGuestContents() {
    }

    private static void showUserContents() {
    }

    private static void showAdminContents() {
        
    }
}
