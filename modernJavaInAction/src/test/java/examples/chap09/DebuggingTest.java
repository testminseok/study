package examples.chap09;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DebuggingTest {

    @Test
    void testMoveRightBy() {
        Debugging.Point p1 = new Debugging.Point(5, 5);
        Debugging.Point p2 = p1.moveRightBy(10);

        assertEquals(15, p2.x());
        assertEquals(5, p2.y());
    }

    /*
    * 람다는 익명함수이므로 테스트코드 이름을 호출할 수 없다.
    * 따라서 필요하다면 람다를 필드에 저장해서 재사용할 수 있으며 람다의 로직을 테스트 할 수 있다.
    * */
    @Test
    void testComparingTwoPoints() {
        Debugging.Point p1 = new Debugging.Point(10, 15);
        Debugging.Point p2 = new Debugging.Point(10, 20);

        int result = Debugging.Point.compareByXAndThenY.compare(p1, p2);
        assertTrue(result < 0);
    }

    @Test
    void testMoveAllPointsRightBy() {
        List<Debugging.Point> points =
                Arrays.asList(new Debugging.Point(5, 5), new Debugging.Point(10, 5));
        List<Debugging.Point> expectedPoints =
                Arrays.asList(new Debugging.Point(15, 5), new Debugging.Point(20, 5));
        List<Debugging.Point> newPoints =
                Debugging.Point.moveAllPointsRightBy(points, 10);

        assertEquals(expectedPoints, newPoints);
    }
}