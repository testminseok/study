package com.software.couping.solution.list;

import java.util.*;

public class LoosingCouplingExample {
    public static void main(String[] args) {
        ListMaker listMaker = new ListMaker();
        /*
        * List 인터페이스로 변수를 선언해
        * List 인터페이스를 바탕으로 구현한
        * 인 변수는 List 인터페이스를 바탕으로
        * 구현한 모든 객체를 받아들일 수 있다.
        * */
        List<String> list = new ArrayList<>();
        list = listMaker.make(list);

        list = new Vector<>();
        list = listMaker.make(list);

        list = new LinkedList<>();
        list = listMaker.make(list);

        list = new Stack<>();
        list = listMaker.make(list);
    }
}
