package d.generic;

public class GenericWildcardSample {
    public static void main(String[] args) {
        GenericWildcardSample sample = new GenericWildcardSample();
        sample.callGenericMethod();
    }

    public void callGenericMethod() {
        WildcardGeneric<String> wildcard = new WildcardGeneric<>();
        genericMethod(wildcard, "Data");
    }
    
    /*
    * Generic Type 을 반환타입 앞에 선언해주며, 선언한 Generic Type 을 매개변수에서 사용하면 컴파일 정상처리
    * */
    public <T> void genericMethod(WildcardGeneric<T> c, T addValue) {
        c.setWildcard(addValue);
        T value = c.getWildcard();

        System.out.println(value);
    }
    
    /*
    * 메소드에 Generic 선언 시 특정 객체를 상속받은 객체만 허용할 경우
    * */
    public <T extends Car> void boundedGenericWildcardMethod(WildcardGeneric<T> c, T addValue) {

    }
    
    /*
    * 메소드에 Generic 선언시 특정 객체를 상속받은 객체와, 다른 객체를 여러개 선언하고 싶을 경우 , 로 구분하여 선언
    * */
    public <S, T extends Car> void multiGenericWildcardMethod(WildcardGeneric<T> c, T addValue, S another) {

    }
}