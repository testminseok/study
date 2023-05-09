package chapter02.item19;

/*
* 일반적인 구체 클래스 즉, 상속용으로 설계하지 않은 클래스는 상속을 금지한다.
*  - final 로 클래스를 선언한다.
*  - 모든 생성자를 private 이나 package-private 으로 선언하고 public 정적 팩터리를 제공한다.
* */
public class Sub extends Super {
    // 초기화되지 않은 final 필드. 생성자에서 초기화한다.
    private final String name;

    Sub() {
        name = "Sub";
    }

    // 재정의 가능 메서드. 상위 클래스의 생성자가 호출한다.
    @Override
    public void overrideMe() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe(); // null 과 Sub 가 출력된다.
    }
}
