package c.annotation;

import c.inheritance.Parent;

public class AnnotationOverride  extends Parent {

    @java.lang.Override
    public void printName(String name) { // Override Annotation 을 메소드 위에 선언 해준경우 컴파일시 부모와 다르면 오류가 발생한다.
        System.out.println("AnnotationOverride.");
    }
}
