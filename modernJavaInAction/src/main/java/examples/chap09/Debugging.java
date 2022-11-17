package examples.chap09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Debugging {

    public static void main(String[] args) {
//        List<Point> points = Arrays.asList(new Point(12, 2), null);
//        points.stream().map(Point::x).forEach(System.out::println);

        /*
        * 메소드를 참조를 사용하는 클래스와 같은 곳에 선언되어 있는 메소드를 참조할 때는
        * 메소드 참조 이름이 스택 트레이스에 나타난다.
        * */
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.stream().map(Debugging::divideByZero).forEach(System.out::println);
    }

    private static int divideByZero(int n) {
        return n / 0;
    }

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
