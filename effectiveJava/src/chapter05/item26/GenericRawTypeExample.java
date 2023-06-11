package chapter02.item26;

import java.util.Collection;
import java.util.Iterator;

public class GenericRawTypeExample {
    // Stamp 인스턴스만 취급한다.
//    private final Collection<Stamp> stamps = null;
    // 매개변수화된 컬렉션 타입 - 타입 안정성 확보
    private final Collection stamps = null;

    public static void main(String[] args) {
        GenericRawTypeExample example = new GenericRawTypeExample();
        example.stamps.add(new Coin()); // 제네릭을 제대로 선언하면 컴파일시 오류 발생
        
        // 반복자의 로 타입 - 따라하지말것
        for (Iterator i = example.stamps.iterator(); i.hasNext(); ) {
            Stamp stamp = (Stamp) i.next(); // ClassCastException 발생
            System.out.println(stamp);
        }
    }

    private static class Coin {
    }

    private static class Stamp {
    }
}
