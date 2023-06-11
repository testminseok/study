package chapter02.item28;

import java.security.SecureRandom;

public class Chooser {
    private final Object[] choiceArray;

    public Chooser(Object[] choiceArray) {
        this.choiceArray = choiceArray;
    }

    /**
     * 이 클래스를 사용하려면 choose 메서드를 호출할때 마다 반환된 Object 를 원하는 타입으로 형변환해야한다.
     * 혹시나 다른 타입의 원소가 들어있을경우 형변환 오류가 발생한다.
     * */
    public Object choose() {
        SecureRandom random = new SecureRandom();
        return choiceArray[random.nextInt(choiceArray.length)];
    }
}
