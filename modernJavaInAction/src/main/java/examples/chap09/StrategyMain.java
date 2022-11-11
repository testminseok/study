package examples.chap09;

public class StrategyMain {
    public static void main(String[] args) {

        /*
        * 기본적인 전략 디자인 패턴을 이용한 캡슐화
        * */
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaa");

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbb");

        System.out.println(b1);
        System.out.println(b2);

        /*
        * 람다표현식을 이용하면 전략 디자인 패턴에서 발생하는 자잘한 코드를 제거할 수 있다.
        * 람다표현식은 코드 조각을 캡슐화 한다. 즉, 람다 표현식으로 전략 디자인 패턴을 대신할 수 있다.
        * */
        // 람다 표현식 사용
        Validator numericValidatorByLambda = new Validator(s -> s.matches("\\d+"));
        System.out.println(numericValidatorByLambda.validate("aaa"));

        Validator lowerCaseValidatorByLambda = new Validator(s -> s.matches("[a-z]+")) ;
        System.out.println(lowerCaseValidatorByLambda.validate("bbb"));

    }
}
