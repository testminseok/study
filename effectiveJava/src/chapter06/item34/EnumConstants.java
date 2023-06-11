package chapter02.item34;

public class EnumConstants {

    /*
    * 열거 타입 자체는 클래스이며, 상수 하나당 자신의 인스턴스를 하나씩 만들어 public static final 필드로 공개한다.
    * 열거 타입은 밖에서 접근할 수 있는 생성자를 제공하지 않으므로 사실상 final 이다.
    * 따라서 클라이언트가 인스턴스를 직접 생성하거나 확장할 수 없으니 열거 타입 선언으로 만들어진 인스턴스들은 딱 하나씩만 존재함을 보장한다.
    * */
    enum Apple { FUJI, PIPPIN, GRANNY_SMITH }
    enum Orange { NAVEL, TEMPLE, BLOOD }
}
