package d.generic;

public class WildcardSample {
    public static void main(String[] args) {
        WildcardSample sample = new WildcardSample();
        sample.callWildcardMethod();
    }

    public void callWildcardMethod() {
        WildcardGeneric<String> wildcard = new WildcardGeneric<>();
        wildcard.setWildcard("A");
        wildcardStringMethod(wildcard);
    }

    public void wildcardStringMethod(WildcardGeneric<?> c) {
        /*
        * Generic Type 을  ? 로 선언했을경우에
        * WildcardGeneric의 객체 중 어떤 타입의 Generic 도 올수 있다, 단 해당 객체의 필드를 가지고 올때는 Object 타입으로 선언해야한다.
        * - ex) WildcardGeneric<String>, WildcardGeneric<Integer>
        * */
        Object value = c.getWildcard();
        System.out.println(value);
    }
}