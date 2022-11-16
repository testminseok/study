package examples.chap09;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Debugging {
    record Point(int x, int y) {
        public static final Comparator<Point> compareByXAndThenY =
                Comparator.comparing(Point::x).thenComparing(Point::y);
        public Point moveRightBy(int x) {
            return new Point(this.x + x, this.y);
        }

        public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
            return points.stream()
                    .map(point -> new Point(point.x() + x, point.y()))
                    .collect(Collectors.toList());
        }
    }
}
