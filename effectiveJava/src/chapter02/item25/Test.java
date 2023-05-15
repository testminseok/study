package chapter02.item25;

/*
* 소스파일 하나에는 반드시 하나의 탑레벨 클래스만 담자.
* */
public class Test {
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }

    private static class Utensil {
        static final String NAME = "pan";
    }

    private static class Dessert {
        static final String NAME = "cake";
    }
}
