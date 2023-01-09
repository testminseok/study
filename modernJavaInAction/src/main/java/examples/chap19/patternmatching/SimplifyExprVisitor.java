package examples.chap19.patternmatching;

/**
 * 방문자 디자인 패턴은
 * 특정 데이터 형식을 '방문'하는 알고리즘을 캡슐화 하는 클래스를 따로 만들 수 있다.
 * 이렇게 분리를 하면 구조를 수정하지 않고도 실질적으로 새로운 동작을 기존의 객체 구조에 추가할 수 있게 된다.
 * 개방-폐쇄 원칙을 적용하는 방법의 하나이다.
 * */
public class SimplifyExprVisitor {

    public Expr visit(BinOp binOp) {

        if ("+".equals(binOp.getOpname()) && binOp.getRight() instanceof Number) {
            return binOp.getLeft();
        }

        return binOp;
    }
}
