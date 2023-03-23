package com.software.design.problem.staticclass;

public class SingletonClassTest2 {
    public static void main(String[] args) {
        /**
         * 싱글톤 클래스를 사용할 때는 getInstance() 메소드를 이용해 유일 객체를 호출한다.
         * 싱글톤 클새느는 생성자가 private 으로 지정돼 있어 외부에서
         * 새로운 객체를 생성할 수 없다.
         * */
        System.out.println(SingletonClassExample2.getInstance().isEmpty(""));
        System.out.println(SingletonClassExample2.getInstance().changeMoney("1234"));
    }
}
