package chapter02.item28;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 런타임에 실패한다.
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in"; // ArrayStoreException

        List<Object> ol = new ArrayList<Long>();
        ol.add("I don't fit in"); // 컴파일 타임에 실패한다.

        // 제네릭 배열 생성을 허용하지 않는 이유 - 컴파일되지 않는다.
        List<String>[] stringLists = new List<String>[1]; // (1)
        List<Integer> intList = List.of(42); // (2)
        Object[] objects = stringLists; // (3)
        objects[0] = intList; // (4)
        String s = stringLists[0].get(0); // (5)

    }
}
