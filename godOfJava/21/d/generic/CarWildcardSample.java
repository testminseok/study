package d.generic;

public class CarWildcardSample {
    public static void main(String[] args) {
        /*
        * Generic Wildcard 문을 사용할 때 범위를 정해주고 싶다면
        * <? extends "ClassName"> 을 사용하여 상속받은것만 허용할 수 있게 할 수 있다.
        * 이것을 Bounded Wildcard 라고 한다.
        * */
        CarWildcardSample sample = new CarWildcardSample();
        sample.callBoundedWildcardMethod();
        sample.callBusBoundedWildcardMethod();
    }

    public void callBoundedWildcardMethod() {
        WildcardGeneric<Car> wildcard = new WildcardGeneric<>();
        wildcard.setWildcard(new Car("Mustang"));
        boundedWildcardMethod(wildcard);
    }

    public void callBusBoundedWildcardMethod() {
        WildcardGeneric<Car> wildcard = new WildcardGeneric<>();
        wildcard.setWildcard(new Bus("6900"));
        boundedWildcardMethod(wildcard);
    }

    public void boundedWildcardMethod(WildcardGeneric<? extends Car> c) {
        Car value = c.getWildcard();
        System.out.println(value);
    }
}