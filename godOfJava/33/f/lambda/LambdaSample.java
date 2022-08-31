package f.lambda;

public class LambdaSample {
    public static void main(String[] args) {
        /*
        * Lambda 를 다용하기 위해서는 interface 에 단일 메소드만 존재해야한다.
        * 때문에 @FunctionalInterface 를 인터페이스에 붙여두는것이 좋다.
        *
        * */
        LambdaSample sample = new LambdaSample();
        sample.calculateClassic();
        sample.calculateLambda();
    }

    private void calculateLambda() {
        Calculate calculateAdd = (a, b) -> a + b;

        System.out.println(calculateAdd.operation(1, 2));
    }

    private void calculateClassic() {
//        Calculate calculateAdd = new Calculate() {
//            @Override
//            public int operation(int a, int b) {
//                return a + b;
//            }
//        };
//
//        System.out.println(calculateAdd.operation(1, 2));
    }
}
