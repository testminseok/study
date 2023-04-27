package chapter02.item08;

public class Adult {
    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("할로~~");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
