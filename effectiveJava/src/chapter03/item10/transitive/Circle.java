package chapter03.item10.transitive;

import java.awt.*;
import java.util.Set;

public class Circle {
    private static final Set<Point> unitCircle = Set.of(
            new Point(1, 0), new Point(0, 1),
            new Point(-1, 0), new Point(0, -1));

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    public static void main(String[] args) {
        /*
        * Point 클래스의 equals 를 getClass 를 사용해 작성해놓았기 때문에
        * CounterPoint 인스턴스의 x,y 값과는 무관하게 false 를 반환한다.
        * Set 을 포함한 대부분의 컬렉션은 equals 를 이용하는데 CounterPoint 인스턴스는 어떤 Point 와도 같이 않기 때문이다.
        * */
        System.out.println(Circle.onUnitCircle(new CounterPoint(0, 1))); // false

        System.out.println(Circle.onUnitCircle(new ColorPointIntoCompositions(1, 0, Color.RED).asPoint())); // true
    }
}
