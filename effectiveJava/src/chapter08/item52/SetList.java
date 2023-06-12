package chapter08.item52;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
* 프로그래밍 언어가 다중정의를 허용한다고 해서 다중정의를 꼭 활용하란 뜻은 아니다.
* 일반적으로 매개변수 수가 같을 때는 다중정의를 피하는게 좋다.
* 상황에 따라, 특히 생성자라면 이 조언을 따르기가 불가능할 수 있다.
* 그럴 때는 헷갈릴 만한 매개변수는 형변환하여 정확한 다중정의 메서드가 선택되도록 해야 한다.
* 이것이 불가능하면, 예컨대 기존 클래스를 수정해 새로운 인터페이스를 구현해야 할 때는 같은 객체를 입력받는 다중정의
* 메서드 들이 모두 동일하게 동작하도록 해야 한다. 그렇지 못하면 프로그래머들은 자중정의된 메서드나 생성자를 효과적으로 사용하지 못할 것이고,
* 의도대로 돋작 하지 않는 이유를 이해하지도 못할 것이다.
* */
public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
//            list.remove(i); // remove(int index) method 를 호출한다.
            list.remove(Integer.valueOf(i));
        }

        System.out.println(set + " " + list); // [-3, -2, -1] [-2, 0, 2]
    }
}
