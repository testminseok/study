package examples.chap19.patternmatching;

import java.util.function.Function;
import java.util.function.Supplier;

public class PatternMatching {
    public static void main(String[] args) {
        Expr expr = new BinOp("+", new Number(5), new Number(0));
        Expr match = simplify(expr);
        System.out.println(match);
    }

    /**
     * new BinOp("+", new Number(5), new Number(0)) 은 Number(5) 로 단순화 할 수 있다.
     * Expr 구조체를 아래 메소드 처럼 탐색할 수 있다.
     * 그러나 코드가 깔끔하지 못하다.
     * */
    public static Expr simplifyExpression(Expr expr) {
        if (expr instanceof BinOp
        && ((BinOp) expr).getOpname().equals("+")
        && ((BinOp) expr).getRight() instanceof Number) {
            return ((BinOp) expr).getLeft();
        }

        return null;
    }

    /**
     * if-then-else 를 없애기 위하여 3항 연산자를 사용한다.
     * 일반 코드에서는 if-then-else 를 사용하는 것이 코드의 명확성을 더 높일 수 있다.
     * 하지만 자바의 switch 와 if-then-else 가 패턴 매칭에는 도움이 되질 않으며
     * 람다를 이용하면 단일 수준의 패턴 매칭을 간단하게 표현할 수 있으므로 여러 개의 if-then-else 구분이 연결되는 상황을
     * 깔끔하게 정리할 수 있다.
     * */
    public static <T> T myIf(boolean b, Supplier<T> truecase, Supplier<T> falsecase) {
        return b ? truecase.get() : falsecase.get();
    }

    /**
     * patternMatchExpr 을 이용해서 덧셈과 곱셉 표현식을 단순화 한다.
     * */
    public static Expr simplify(Expr expr) {
        TriFunction<String, Expr, Expr, Expr> binopcase = // BinOp 표현식 처리
                (opname, left, right) -> {
                    if ("+".equals(opname)) { // 더하기 처리
                        if (left instanceof Number && ((Number) left).getValue() == 0) {
                            return right;
                        }

                        if (right instanceof Number && ((Number) right).getValue() == 0) {
                            return left;
                        }
                    }

                    if ("*".equals(opname)) { // 곱셈처리
                        if (left instanceof Number && ((Number) left).getValue() == 1) {
                            return right;
                        }

                        if (right instanceof Number && ((Number) right).getValue() == 1) {
                            return left;
                        }
                    }

                    return new BinOp(opname, left, right);
                };

        Function<Integer, Expr> numcase = val -> new Number(val);
        Supplier<Expr> defaultcase = () -> new Number(0); // 수식을 인식할 수 없을 때 기본처리

        return patternMatchExpr(expr, binopcase, numcase, defaultcase); // 패턴 매칭 적용
    }

    /**
     * BinOp 와 Number 두 서브 클래스를 포함하는 Expr 클래스의 패턴 매칭 값으로 돌아와서
     * patternMatchExpr 이라는 메소드를 정의 할 수 있다.
     * patternMatchExpr 메소드는 e 가 BinOp 인지 아니면 Number 인지 확인한다.
     * Binop 나 Number 가 아닌 트리 노드를 생성했을 떄 실행되는 defaultcode 도 존재한다.
     * */
    public static <T> T patternMatchExpr(
            Expr e,
            TriFunction<String, Expr, Expr, T> binopcase,
            Function<Integer, T> numcase,
            Supplier<T> defaultcase) {
        return
                (e instanceof BinOp) ?
                        binopcase.apply(((BinOp) e).getOpname(), ((BinOp) e).getLeft(), ((BinOp) e).getRight()) :
                        (e instanceof Number) ? numcase.apply(((Number) e).getValue()) : defaultcase.get();
    }
}
