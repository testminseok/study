package com.software.basic.problem;

/**
 * 8-3 연관성 있는 변수는 하나의 객체로 묶는다.
 * - TooManyFieldsExample : 클래스 멤버변수가 15개 이상일 경우 수정을 권고한다.
 *                          필드가 너무 많은 클래스는 다루기 어려워질 수 있으며, 관련 필드를 새로운 클래스로 그룹화 하여 더 세분화할 수 있다.
 * - ExcessiveParameterList : 매개변수가 10개 이상인 메소드가 있는경우 수정을 권고한다.
 *                            매개변수가 많은 메소드는 특히 동일한 데이터 타입을 가지는 경우 유지관리가 매우 어렵다.
 */
public class TooManyFieldsExample {

    // 너무 많은 클래스 멤버 변수는 가독성을 저해하는 주된 요소다.
    private String userId;
    private String userPwd;
    private String username;
    private String address;

    private String documentId;
    private String title;
    private String body;
    private String author;
    private String date;

    private String etc0;
    private String etc1;
    private String etc2;
    private String etc3;
    private String etc4;
    private String etc5;
    private String etc6;

    public static void main(String[] args) {

    }

    public static void tooManyParameterList(String text0, String text1, String text2, String test3, String test4,
                                            String text5, String text6, String text7, String text8, String text9) {

    }

}
