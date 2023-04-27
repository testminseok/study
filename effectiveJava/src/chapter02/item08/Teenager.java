package chapter02.item08;

public class Teenager {
    public static void main(String[] args) {
        // Room 의 close 메서드가 호출되지 않는다.
        new Room(99);
        System.out.println("아무렴");
    }
}
