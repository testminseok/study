package com.software.optimize.problem;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * 11-1 적절한 컬렉션 선택은 소프트웨어의 성능을 좌우한다.
 * UseArrayListInsteadOfVector : Vector 를 사용하고 있는곳이 있다면 수정을 권고한다. (스레드 동기화가 필요하지 않다면 수정하자.)
 * UseConcurrentHashMap : HashTable 을 사용하고 있는 곳이 있다면 수정을 권고한다.
 *                        - 자바 5 이상에서 부터는 ConcurrentHashMap 가 멀티 스레드 환경을 위해서 HashMap 을 보안하여 만든 클래스이다.
 *                        - ConcurrentHashMap 은 동기화 처리를 Entry 단위로 하기 때문에 HashTable 보다 더욱 빠르다.
 * ReplaceHashtableWithMap : HashTable 을 사용하고 있는 곳이 있다면 수정을 권고한다.
 * ReplaceVectorWithList : Vector 를 사용하고 있는곳이 있다면 수정을 권고한다.
 * */
public class CollectionExample {

    public static void main(String[] args) {
        // 스레드로부터 안전한 작업이 필요하지 않은 경우라면 ArrayList 를 사용하는것이 좋다.
        List<String> vector = new Vector();
        Vector<String> vector1 = new Vector<>();

        Map<String, String> map = new Hashtable<>();
        Hashtable<String, String> hashtable = new Hashtable<>();
    }
}
