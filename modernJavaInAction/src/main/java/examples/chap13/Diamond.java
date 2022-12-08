package examples.chap13;

/*
* 다른 클래스나 인터페이스로부터 같은 시그니처를 갖는 메소드를 상속받을 때는 세가지 규칙을 따라야 한다.
* 1. 클래스가 항상 이긴다. 클래스나 슈퍼클래스에서 정의한 메소드가 디폴트 메소드보다 우선권을 갖는다.
* 2. 1번 규칙 이외의 상황에서는 서브인터페이스가 이긴다. 즉 B 가 A 를 상속 받는다면 B 가 A 를 이긴다.
* 3. 여전히 디폴트 메소드의 우선순위가 결정되지 않았다면 여러 인터페이스를 상속받는 클래스가 명시적으로
*       디폴트 메소드를 오버라이드하고 호출해야한다.
* */
public class Diamond {

    interface A {
        default void hello() {
            System.out.println("hello from A");
        }
    }

    interface B extends A {
        default void hello() {
            System.out.println("hello from B");
        }
    }

    static class D implements A {
    }

    static class C extends D implements B, A {
        public static void main(String[] args) {
            /*
            * B가 A를 상속받기 때문에 2번 규칙에 의해 B가 출력됨
            * extends D 가 없을때
            * */
            new C().hello();
            /*
            * extends D 가 추가되었을때
            * 1번 규칙에 의해 D 의 hello 가 출력되어야하지만 hello 를 오버라이드 하지 않았으므로,
            * 2번 규칙에 의해 서브 인터페이스인 B의 hello 가 출력된다
            * */
            new C().hello();
        }
    }
}
