package chapter02.item28;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericChooser<T> {
    private final T[] choiceArray;
    private final List<T> choiceList;

    public GenericChooser(Collection<T> choices) {
        // 컴파일이 되지 않는다.
//        choiceArray = choices.toArray();
        // Object 배열을 T 배열로 형변환해야한다.
        this.choiceArray = (T[]) choices.toArray();
        this.choiceList = new ArrayList<>(choices);
    }

    public GenericChooser(T[] choiceArray) {
        this.choiceArray = choiceArray;
        this.choiceList = List.of(choiceArray);
    }

    public T choose() {
        SecureRandom random = new SecureRandom();
//        return choiceArray[random.nextInt(choiceArray.length)];
        return choiceList.get(random.nextInt(choiceList.size()));
    }
}
