package examples.chap09;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/*
* 의무 체인 패턴에서 람다 사용하기
* */
public class ChainOfResponsibilityMain {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2); // 두 작업 처리를 연결한다.
        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        // from lambda
        UnaryOperator<String> headerProcessing =
                (String input) -> "From Raoul, Mario and alan: " + input;
        UnaryOperator<String> spellCheckerProcessing =
                (String input) -> input.replaceAll("labda", "lambda");
        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckerProcessing);
        pipeline.apply("Aren't labdas really sexy?!!");
    }

    static abstract class ProcessingObject<T> {
        protected ProcessingObject<T> successor;

        public T handle(T input) {
            T r = handleWork(input);
            if (successor != null) {
                return successor.handle(r);
            }
            return r;
        }

        abstract protected T handleWork(T input);

        public void setSuccessor(ProcessingObject<T> successor) {
            this.successor = successor;
        }
    }

    static class HeaderTextProcessing extends ProcessingObject<String> {
        @Override
        protected String handleWork(String input) {
            return "From Raoul, Mario and alan: " + input;
        }
    }

    static class SpellCheckerProcessing extends ProcessingObject<String> {
        @Override
        protected String handleWork(String input) {
            return input.replaceAll("labda", "lambda");
        }
    }
}
