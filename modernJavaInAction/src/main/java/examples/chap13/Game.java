package examples.chap13;

import java.util.Arrays;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        /*
        * 인터페이스에 새로운 메소드를 추가하면 바이너리 호환성은 유지되므로 새로 추가된 메소드를 호출하지만 않으면
        * 새로운 메소드 구현이 없이도 기존 클래스 파일 구현이 잘 작동한다.
        *
        * 그외에도 소스 호환성, 동작 호환성이 있다.
        * 소스 호환성 - 코드를 고쳐도 기존 프로그램을 성공적으로 재컴파일 할 수 있음
        * 동작 호환성 - 코드를 바꾼 다음에도 같은 입력값이 주어지면 프로그램이 같은 동작을 실핼
        * */
        List<Resizable> resizableShapes = Arrays.asList(new Square(), new Rectangle(), new Ellipse());
        Utils.paint(resizableShapes);

        Monster monster = new Monster();
        monster.rotateBy(180); // Rotatable 의 디폴트 메소드
        monster.moveHorizontally(10); // Moveable 의 디폴트 메소드
    }

    private static class Utils {
        public static void paint(List<Resizable> resizableShapes) {
            resizableShapes.forEach(r -> {
                r.setAbsoluteSize(42, 42);
                r.draw();
            });
        }
    }
}
