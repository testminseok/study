package chapter08.item56;

import java.lang.annotation.*;

/**
 * 이 애너테이션이 달린 메서드는 명시한 예외를 던져야만 성공하는 테스트 메서드임을 나타낸다.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    /**
     * 이 애너테이션을 단 테스트 메서드가 성공하려면 던져야 하는 예외,
     * (이 클래스의 하위 타입 예외는 모두 허용된다.)
     * */
    Class<? extends Throwable> value();
}

