package d.lang;

public class JavaLangNumber {

    public static void main(String[] args) {

        /*
         * 참조자료형 중에서  Byte, Short, Integer, Long, Float, Double 클래스는
         * 기본 자료형처럼 사용 할 수 있다.
         *
         * 이러한 기본자료형의 참조자료형을 사용하는 이유는
         *  - 매개변수를 참조 자료형으로만 받는 메소드를 처리하기 위해서
         *  - 제네릭과 같이 기본 자료형을 사용하지 않는 기능을 사용하기 위해서
         *  - MIN_VALUE, MAX_VALUE 와 같은 클래스변수를 사용하기 위해서
         *  - 문자열을 숫자로, 숫자를 문자열로 쉽게 변환하고 , 2, 8, 10, 16진수 변환을 쉽게 처리하기 위해서
         */
        JavaLangNumber sample = new JavaLangNumber();
        sample.numberTypeCheck();
        sample.numberMinMaxCheck();
    }

    public void numberTypeCheck() {
        String value1 = "3";
        String value2 = "5";
        byte byte1 = Byte.parseByte(value1);
        byte byte2 = Byte.parseByte(value2);

        System.out.println(byte1 + byte2);

        Integer refInt1 = Integer.valueOf(value1);
        Integer refInt2 = Integer.valueOf(value2);

        System.out.println(refInt1 + refInt2 + "7");
    }

    public void numberMinMaxCheck() {

        System.out.println("Byte min = " + Byte.MIN_VALUE + ", max = " + Byte.MAX_VALUE);
        System.out.println("Short min = " + Short.MIN_VALUE + ", max = " + Short.MAX_VALUE);
        System.out.println("Integer min = " + Integer.MIN_VALUE + ", max = " + Integer.MAX_VALUE);
        System.out.println("Integer BINARY min = " + Integer.toBinaryString(Integer.MIN_VALUE) + ", BINARY max  = " + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("Long min = " + Long.MIN_VALUE + ", max = " + Long.MAX_VALUE);
        System.out.println("Float min = " + Float.MIN_VALUE + ", max = " + Float.MAX_VALUE);
        System.out.println("Double min = " + Double.MIN_VALUE + ", max = " + Double.MAX_VALUE);
        System.out.println("Character min = " + (int) Character.MIN_VALUE + ", max = " + (int) Character.MAX_VALUE);
    }

}