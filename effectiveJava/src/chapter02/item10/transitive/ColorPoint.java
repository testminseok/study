package chapter02.item10.transitive;

import java.awt.*;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        System.out.println(p.equals(cp)); // true
        System.out.println(cp.equals(p)); // false

        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);

        // 추이성 위배
        System.out.println(p1.equals(p2)); // true
        System.out.println(p2.equals(p3)); // true
        System.out.println(p1.equals(p3)); // false
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        // o 가 일반 Point 면 색상을 무시하고 비교한다.
        // 대칭성은 지겨쿠지만, 추이성은 깨버린다.
        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }

        /*
        * Point 의 equals 는 생상을 무시하고, ColorPoint 의 equals 는 입력 매개변수의 클래스 종류가 다르며
        * 매번 false 만 반환할 것이다.
        * */
        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}
