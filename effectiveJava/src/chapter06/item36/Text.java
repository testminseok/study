package chapter02.item36;

public class Text {

    /*
    * 비트 필드 열거 상수 - 구닥다리 기법!
    * 열거한 값들이 주로 집합으로 사용될 겨우, 예전에는 각 상수에 서로 다른 2의 거듭제곱 값을 할당한
    * 정수 열거 패턴을 사용해왔다.
    *
    * 장점
    * - 비트별 OR (|) 를 사용해 여러 상수를 하나의 집합으로 모을 수 있다.
    * - 비트 필드를 사용하면 비트별 연산을 사용해 합집합과 교집합 같은 집합 연산을 효율적으로 수행할 수 있다.
    * 단점
    * - 비트 필드 값이 그대로 출력되면 단순한 정수 열거 상수를 출력할 때보다 해석하기가 훨씬 어렵다.
    * - 비트 필드 하나에 녹아 있는 모든 원소를 순회하기도 까다롭다.
    * - 최대 몇 비트가 필요한지를 API 작성 시 미리 예측하여 적절한 타입(보통 int or long)을 선택해야 한다.
    * */
    public static final int STYLE_BOLD = 1 << 0; // 1
    public static final int STYLE_ITALIC = 1 << 1; // 2
    public static final int STYLE_UNDERLINE = 1 << 2; // 4
    public static final int STYLE_STRIKETHROUGH = 1 << 3; // 8

    // 매개변수 styles 는 0개 이상의 STYLE_ 상수를 비트별 OR 한 값이다.
    public void applyStyles(int styles) {
        System.out.println(styles);
    }
}
