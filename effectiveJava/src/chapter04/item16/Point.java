package chapter02.item16;

public class Point {

    // 이처럼 퇴보한 클래스는 public 이어서는 안된다.
    public double x;
    public double y;

    /*
    * 접근자와 변경자 메서드를 활용해 데이터를 캡슐화 한다.
    * 패키지 바깥에서 접근할 수 있는 클래스라면 접근자를 제공함으로써 클래스 내부 표현 방식을 언제든지 변경할 수 있는 유연성을 얻을 수 있다.
    * */
    private double privateX;
    private double privateY;

    public double getPrivateX() {
        return privateX;
    }

    public void setPrivateX(double privateX) {
        this.privateX = privateX;
    }

    public double getPrivateY() {
        return privateY;
    }

    public void setPrivateY(double privateY) {
        this.privateY = privateY;
    }

    /*
    * package-private 클래스 혹은 private 중첩 클래스라면 데이터 필드를 노출한다 해도 하등의 문제가 없다.
    * package-private 클래스나 private 중첩 클래스에서는 종종(불변이든 가변이든) 필드를 노출하는 편이 나을 때도 있다.
    * */
    private class Line {
        public double x;
        public double y;

        public double x2;
        public double y2;
    }

    class Line2 {
        public double x;
        public double y;

        public double x2;
        public double y2;
    }
}
