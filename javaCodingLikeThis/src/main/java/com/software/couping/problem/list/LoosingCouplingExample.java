package com.software.couping.problem.list;

import java.util.*;

/**
 * 10-1 객체를 선언할 때는 클래스가 아닌 인터페이스로 선언한다
 * - LooseCoupling : 변수의 구현체로 상세 구현 객체보다 인터페이스로 변수를 선언하기를 권고한다.
 *                   구현체로 상세 구현 객체를 사용하면 향후 요구 사항이 변경됨에 따라 대체 구현을 사용할 수 있는 유연성이 떨어진다.
 *                   인터페이스로 객체를 참조하면 훨씬 더 많은 유연성 및 확장성을 얻을 수 있다.
 */
public class LoosingCouplingExample {

    private ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        VectorMaker vectorMaker = new VectorMaker();
        ArrayListMaker arrayListMaker = new ArrayListMaker();

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList = arrayListMaker.add(arrayList);

        Vector<String> vector = new Vector<>();
        vector = vectorMaker.add(vector);
    }
}
