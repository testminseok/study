package com.software.basic.problem;

/**
 * 1-13 잘못 하드코딩된 IP 는 위험하다.
 * - AvoidUsingHardCodeIP : 모든 소스코드에서 하드코딩된 IP 주소를 찾아 경고하고 수정하기를 권고한다.
 */
public class IPExample {

    private static final String SERVER_IP = "127.0.0.1";

    /**
     * 서버의 IP 는 관리적인 측면과 보안상의 이유로 유동적으로 변결될 수 있다는 점을 명심해야한다.
     * IP를 소스코드에 하드코딩한다면 해당 IP가 변경되면 그에 맞춰 하드코딩된 소스도 변경해야 하므로
     * IP가 변경될따마다 불필요한 소스 수정과 재컴파일이 필요하다.
     *
     * 또한 자바 소스는 디컴파일이 가능하기 때문에 IP 같은 중요 정보가 담긴 .class 파일이 유출된다면 디컴파일을 통해 관련 정보도
     * 함께 유출될 수 있다.
     *
     * 때문에 이를 위해서 자바에서는 IP 주소 같은 설정값을 관리하는 다양한 수단을 제공하며,
     * 그 중에서 java.util.Properties 가 가장 대표적인 방법으로 별도로 설정 파일을 만들어 설정값을 저장한는 방식을 지원한다.
     * */
    public static void main(String[] args) {
        System.out.println(SERVER_IP);
    }
}
