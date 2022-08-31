package f.functional;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        /*
        * FunctionalInterface 중 Predicate interface 는 비교를 위해 사용되며 boolean 값을 리턴한다.
        * */
        PredicateExample example = new PredicateExample();

        Predicate<String> predicateLength = a -> a.length() > 5;
        Predicate<String> predicateContains = a -> a.contains("God");
        Predicate<String> predicateStringWith = a -> a.startsWith("God");

        String godOfJava = "GodOfJava";
        String goodJava = "GoodJava";

        example.predicateTest(predicateLength, godOfJava);
        example.predicateTest(predicateLength, goodJava);

        example.predicateNegate(predicateLength, godOfJava);
        example.predicateNegate(predicateLength, goodJava);

        example.predicateAnd(predicateLength, predicateContains, godOfJava);
        example.predicateAnd(predicateLength, predicateContains, goodJava);

        example.predicateOr(predicateLength, predicateStringWith, godOfJava);
        example.predicateOr(predicateLength, predicateStringWith, goodJava);
    }

    private void predicateOr(Predicate<String> predicate, Predicate<String> predicate1, String data) {
        System.out.println(predicate.or(predicate1).test(data));
    }

    private void predicateAnd(Predicate<String> predicate, Predicate<String> predicate1, String data) {
        System.out.println(predicate.and(predicate1).test(data));
    }

    private void predicateNegate(Predicate<String> predicate, String data) {
        System.out.println(predicate.negate().test(data));
    }

    private void predicateTest(Predicate<String> predicate, String data) {
        System.out.println(predicate.test(data));
    }


}
