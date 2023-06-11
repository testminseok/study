package chapter02.item25;

public class Main {
    public static void main(String[] args) {

        // javac Main.java Utensil.java 를 실행하면 pan cake 가 출력된다.
        // javac Main.java Dessert.java 를 실행하면 pot pie 가 출력된다.
        System.out.println(Utensil.NAME + Dessert.NAME);
    }
}
