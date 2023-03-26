package com.software.couping.solution.list;

import java.util.List;

public class ListMaker {

    /**
     * 메소드의 인자와 반환 값의 자료형을 List 인터페이스로 선언함으로써
     * List 인터페이스를 바탕으로 구현한 모든 구현 객체는
     * 이 메소드를 활용할 수 있다.
     * */
    public List<String> make(List<String> list) {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        return list;
    }
}
