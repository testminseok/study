package examples.chap19.patternmatching;

public class PatternMatching {
    public static void main(String[] args) {

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
}
