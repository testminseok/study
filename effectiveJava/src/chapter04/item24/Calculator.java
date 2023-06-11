package chapter02.item24;

public class Calculator {

    private String anyValue = "aaaa";

    public static void main(String[] args) {
        System.out.println(Calculator.Operation.PLUS); // 클라이언트가 사용할때

        Calculator calculator = new Calculator();
        calculator.new NonStaticClass().nonStaticMethod(); // 드물게 비정적 직접 생성자를 호출해 수동으로 만들기도한다.

    }

    public long calculate(long a, long b, String operation) {
        switch (operation) {
            case Operation.PLUS:
                return a + b;
            case Operation.MINUS:
                return a - b;
            case Operation.MULTIPLY:
                return a * b;
            case Operation.DIVIDE:
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }

    static class Operation {
        public static final String PLUS = "+";
        public static final String MINUS = "-";
        public static final String MULTIPLY = "*";
        public static final String DIVIDE = "/";
    }

    /*
    * 비정적 멤버 클래스의 인스턴스는 바깥 클래스의 인스턴스와 암묵적으로 연결된다.
    * 따라서 비정적 멤버 클래스의 인스턴스 메서드에서 정규화된 this를 사용해 바깥 인스턴스의 메서드를 호출하거나
    * 바깥 인스턴스의 참조를 가져올 수 있다.
    *
    * 비정적 멤버 클래스의 인스턴스와 바깥 인스턴스 사이의 관계는 멤버 클래스가 인스턴스화될 때 확립되며, 더 이상 변경할 수 없다.
    * 이 관계는 바깥 클래스의 인스턴스 메서드에서 비정적 클래스의 생성자를 호출할 때 자동으로 만들어지는게 보통이지만
    * 드물게 수동으로 만들기도한다. (calculator.new NonStaticClass().nonStaticMethod())
    * 이 관계 정보는 비정적 멤버 클래스의 인스턴스 안에 만들어져 메모리 공간을 차지하며, 생성 시간도 오래걸린다.
    *
    * 멤버 클래스에서 바깥 인스턴스에 접근할 일이 없다면 무조건 static 을 붙여서 정적 멤버 클래스로 만들자.
    * static 을 생략하면 바깥 인스턴스로의 숨은 외부 참조를 갖게 되며, 이 참조를 저장하려면 시간과 공간을 소비한다.
    * 또한 가비지 컬렉션이 바깥 클래스의 인스턴스를 수거하지 못하는 메모리 누수가 생길 수 있다.
    * */
    class NonStaticClass {
        public void nonStaticMethod() {
            // 정규화된 this (클래스명.this) 를 사용해 바깥 인스턴스의 메소드를 호출
            Calculator.this.calculate(1, 2, Calculator.Operation.PLUS);

            // 정규화된 this 를 사용해 바깥 인스턴스의 참조를 가져온다.
            System.out.println(anyValue);
        }
    }
}
