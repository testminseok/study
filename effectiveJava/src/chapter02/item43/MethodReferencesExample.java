package chapter02.item43;

import java.util.HashMap;
import java.util.Map;

public class MethodReferencesExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // 람다식을 함수 객체로 사용 - Map.merge 메서드 사용
        map.merge("key", 1, (count, incr) -> count + incr);

        // 자바 8의 메서드 참조 기능을 사용한 코드
        map.merge("key", 1, Integer::sum);
    }

    private static class GoshThisClassNameIsHumongous {

        public static void main(String[] args) {
            /*
            * 보통 람다를 사용하는것보다 메서드 참조가 더욱 간결하지만 같은 클래스의 메서드를 사용할때는 람다가 더 간결할 수 있다.
            * 때문에 메서드 참조 쪽이 짧고 명확하다면 메서드 참조를 쓰고, 그렇지 않을 때만 람다를 사용하라.
            * */
            Runnable action = GoshThisClassNameIsHumongous::action;
            Runnable actionLambda = () -> action();
        }
        public static void action() {
            System.out.println("Hello");
        }
    }
}
