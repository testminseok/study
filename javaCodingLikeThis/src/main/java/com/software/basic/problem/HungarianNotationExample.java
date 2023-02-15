package com.software.basic.problem;

/**
 * 2-9 헝가리안 표기법
 */
public class HungarianNotationExample {
    private String m_strValue; // m(member)_str(String)Value
    private int m_nLength; // 의미가 중복된 변수명
    private String strName; // 의미가 중복된 변수명 name 은 그자체로 string 값을 의미한다.

    /*
    * 헝가리안 표기법은 MS의 헝가리인 개발자가 사용한 변수 표기법으로
    * 모든 변수명의 접두사로 변수의 자료형을 붙여서 변수의 시인성을 높여주는 표기법이다.
    * 그러나 모순되게도 변수의 가독성을 저해한다는 의견이 더 많아 사용을 자제하고 있다.
    * */
    public static void main(String[] args) {
        int nValue; // 헝가리안 표기법을 따른 변수
        int fValue; //헝가리안 표기법을 따른 변수
    }
}
