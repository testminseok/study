package examples.chap19.patternmatching;

public class SimplifyExprVisitor {

    public Expr visit(BinOp binOp) {

        if ("+".equals(binOp.getOpname()) && binOp.getRight() instanceof Number) {
            return binOp.getLeft();
        }

        return binOp;
    }
}
