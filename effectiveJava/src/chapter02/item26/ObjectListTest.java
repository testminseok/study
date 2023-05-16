package chapter02.item26;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectListTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
    }

    private static void unsafeAdd(List list, Object o) {
//    private static void unsafeAdd(List<Object> list, Object o) { // 컴파일 오류 발생
        list.add(o);
    }

    // 잘못된 예 - 모르는 타입의 원소도 받는 로 타입을 사용했다.
//    static int numElementsInCommon(Set s1, Set s2) {
    // 비한정적 와일드카드 타입을 사용하라 - 타입 안전하며 유연하다.
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }
}
