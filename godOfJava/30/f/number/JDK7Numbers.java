package f.number;

public class JDK7Numbers {
    public static void main(String[] args) {
        JDK7Numbers numbers = new JDK7Numbers();
        numbers.jdk6();
        numbers.jdk7();
    }

    private void jdk7() {
        int binaryVal = 0b100_0101_0010; // JDK 7부터 2진수 표기법 추가
        int million = 1_000_000; // 숫자에 _ 사용가능
        System.out.println(binaryVal);
    }

    private void jdk6() {
        int decVal = 1106; // 10진수
        int octVal = 02122; // 8진수
        int hexVal = 0x456; // 16진수

        System.out.println(decVal);
        System.out.println(octVal);
        System.out.println(hexVal);
    }
}
