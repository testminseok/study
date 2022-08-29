package f.defaultmethod;

public interface DefaultStaticInterface {
    /*
     * JDK8 이전 인터페이스는 구현체가 없는 메소드만 가능했다.
     * 하지만 JDK8 부터는 default 라는 키워드를 이용해 인터페이스에서도
     * 구현체를 가질 수 있는 메소드를 생성할 수 있는데, 이는 하위호환성 때문이다.
     *
     * 또한 인터페이스 메소드에서 static 키워드를 붙일 수 있게 되었다.
     * static 이 붙은 메소드는 overriding 이 불가능하다.
     * */
    static final String name = "GodOfJavaBook";
    static final int since = 2013;
    String getName();
    int getSince();

    default String getEmail() {
        return name + "@abcdefg.com";
    }

    static void print() {
        System.out.println("인터페이스 static 메소드");
    }
}
