package com.software.basic.problem;

import java.util.HashMap;
import java.util.Map;

public class TestKlass {
    public static void main(String[] args) {
        SampleKlass sampleKlass = new SampleKlass(1, "test");
        SampleKlass sampleKlass2 = new SampleKlass(1, "test2");
        SampleKlass sampleKlass3 = new SampleKlass(1, "test");

        System.out.println(sampleKlass.equals(sampleKlass2)); // false
        System.out.println(sampleKlass.equals(sampleKlass3)); // true

        /*
        * hashCode 를 오버라이드하지 않았기 떄문에 HashMap 에서는 저장된 객체의 키와 새로 입력한 객체의 키를
        * 서로 다른 키로 인식해서 null 을 반환한다.
        * */
        Map<SampleKlass, String> objectMap = new HashMap<>();
        objectMap.put(new SampleKlass(1, "test"), "value");

        System.out.println(objectMap.get(new SampleKlass(1, "test")));
    }
}
