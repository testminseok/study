package com.software.optimize.solution;

public class UnnecessaryWrapperObjectCreationExample {
    public static void main(String[] args) {
        String s = "0";

        Integer i  = 1;

        /*
        * valueOf()는 새로운 Integer 인스턴스를 생성하지만
        * parseInt 는 새로운 Integer 인스턴스를 생성하지 않는다.
        * */
        int i2 = Integer.parseInt(s);
        double d = Double.parseDouble(s);
        float f = Float.parseFloat(s);

        System.out.println(i2);
        System.out.println(d);
        System.out.println(f);

        /*
        * 박스화 기본형은 기본적으로 문자열로 변환하기 위한 toString() 메소드를 재정의하고 있다.
        * 따라서 "" + intValue 와 같이 공백 문자를 이용한 형변환은 불필요하다.
        * */
        String s1 = Integer.toString(i2);
        String s2 = Double.toString(1.1);

        Double d2 = 1.2;

        String s3 = d2.toString();

        System.out.println(d2 + " : " + s3);
    }
}
