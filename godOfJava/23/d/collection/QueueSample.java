package d.collection;

import java.util.LinkedList;

public class QueueSample {
    public static void main(String[] args) {
        QueueSample sample = new QueueSample();
        sample.checkLinkedList1();
    }

    public void checkLinkedList1() {
        /*
        * LinkedList 는 상속받은 인터페이스가 다양하여 오버라이딩된 함수들이 많이 존재하며,
        * push() 와 addFirst, offerFirst 등 LinkedList 는 내부적으로 같은 동작을 하는 메소드가 여러개 있지만, 그 차이는 없다.
        * 때문에 메소드 명에 따라 소스를 보는 사람이 헷갈릴 수 있으므로 한가지만 선정하여 사용하는것이 좋다.
        * */
        LinkedList<String> link = new LinkedList<>();
        link.add("A"); // add() -> linkLast()
        link.addFirst("B"); // addFirst() -> linkFirst()
        System.out.println(link);
        link.offerFirst("C");  // offerFirst() -> addFirst() -> linkFirst();
        System.out.println(link);
        link.addLast("D"); // addLast() -> linkLast()
        System.out.println(link);
        link.offer("E"); // offer() -> add() -> linkLast()
        System.out.println(link);
        link.offerLast("F"); // offerLast() -> addLast() -> linkLast()
        System.out.println(link);
        link.push("G"); // push() -> addFirst() -> linkFirst()
        System.out.println(link);
        link.add(0, "H");
        System.out.println(link);
        System.out.println("EX = " + link.set(0, "I"));
        System.out.println(link);
    }
}
