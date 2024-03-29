package examples.chap19.patternmatching;

public class BinOp extends Expr {
    private String opname;

    private Expr left, right;

    public BinOp(String opname, Expr left, Expr right) {
        this.opname = opname;
        this.left = left;
        this.right = right;
    }

    public Expr accept(SimplifyExprVisitor exprVisitor) {
        return exprVisitor.visit(this);
    }

    public String getOpname() {
        return opname;
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }
}
