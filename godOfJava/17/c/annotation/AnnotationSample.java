package c.annotation;

public class AnnotationSample {
    @SuppressWarnings("deprecation")
    public void useDeprecated() {
        /*
        * Deprecated Method 사용한 경우 코드 컴파일 시 경고 문구가 노출된다.
        * */
        AnnotationDeprecated child = new AnnotationDeprecated();
        child.noMoreUse();
    }
}
