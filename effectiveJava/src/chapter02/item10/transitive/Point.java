package chapter02.item10.transitive;

import java.util.Objects;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
//        if (!(o instanceof Point)) {
//            return false;
//        }

        // 리스코프 치환 원칙 위배
        // Point 의 하위 클래스는 정의상 여전히 Point 이므로 어디서든 Point 로써 활용될 수 있어야한다.
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Point p = (Point)o;
        return p.x == x && p.y == y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
