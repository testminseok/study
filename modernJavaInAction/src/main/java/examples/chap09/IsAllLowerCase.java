package examples.chap09;

/**
 * 문자열을 검증하는 클래스
 * */
public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
