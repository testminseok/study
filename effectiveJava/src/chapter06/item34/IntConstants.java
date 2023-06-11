package chapter02.item34;

public class IntConstants {
    /*
    * 정수 열거 패턴 - 상당히 취약하다.
    * 정수 열거형 패턴을 사용한 프로그램은깨지기 쉽다. 평범한 상수를 나열한것 뿐이라 컴파일하면 그 값이 클라이너트 파일에
    * 그대로 새겨진다. 따라서 상수의 값이 바뀌면 클라이언트도 반드시 다시 컴파일해야 한다는 것이다.
    * */
    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;

    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;
}
