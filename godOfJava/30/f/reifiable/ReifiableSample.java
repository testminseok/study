package f.reifiable;

import java.util.ArrayList;
import java.util.Collections;

public class ReifiableSample {
    public void addData() {
        /*
        * 가변 매개변수는 내부적으로 Object[] 의 형태로 사용되는데
        * JDK6 에서는 @SafeVarargs 라는 어노테이션이 없기 때문에 경고가 발생한다.
        * JDK7 에서는 해당 어노테이션이 추가되었다.
        * @SafeVarargs 는 다음의 경우만 사용할 수 있다.
        * 가변 매개변수를 사용하고
        * final 이나 static 으로 선언되어있어야한다.
        *
        * 가변 매개변수가 reifiable 타입이고,
        * 메소드 내에서 매개 변수를 다른 벼수에 대입하는 작업을 수행할 경우
        * 컴파일러에서 경고가 발생한다.
        * */
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> newDataList = new ArrayList<>();

        newDataList.add("A");
        Collections.addAll(list, newDataList);

        System.out.println(list);
    }
}
