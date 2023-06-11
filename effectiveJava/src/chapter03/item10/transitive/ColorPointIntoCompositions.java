package chapter03.item10.transitive;

import java.awt.Color;
import java.util.Objects;

public class ColorPointIntoCompositions {
    private final Point point;
    private final Color color;

    public ColorPointIntoCompositions(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    // 이 ColorPoint 의 Point 뷰를 반환한다.
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ColorPointIntoCompositions)) {
            return false;
        }

        ColorPointIntoCompositions cp = (ColorPointIntoCompositions) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
