package chapter02.item39;

import chapter02.item39.annotation.ExceptionTest;
import chapter02.item39.annotation.ExceptionTestContainer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExceptionTestAnnotationProcessor {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName("chapter02.item39.ExceptionTestAnnotationSample");
        for (Method m : testClass.getDeclaredMethods()) {
            // ExceptionTest 를 하나만 사용할때와 여러개를 사용할때를 구분한다. 여러개를 사용할 때는 ExceptionTestContainer 를 사용한다.
            if (m.isAnnotationPresent(ExceptionTest.class) || m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException ite) {
                    Throwable exc = ite.getCause();
                    int oldPassed = passed;

//                    Class<? extends Throwable>[] excTypes = m.getAnnotation(ExceptionTest.class).value();
//                    for (Class<? extends Throwable> excType : excTypes) {
//                        if (excType.isInstance(exc)) {
//                            passed++;
//                            break;
//                        }
//                    }
                    // Repeatable 을 사용하면 ExceptionTest 를 여러개 사용할 수 있다.
                    ExceptionTest[] excTests = m.getAnnotationsByType(ExceptionTest.class);
                    for (ExceptionTest excTest : excTests) {
                        if (excTest.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }

                    if (passed == oldPassed) {
                        System.out.printf("테스트 %s 실패: %s %n", m, exc);
                    }
                } catch (Exception exc) {
                    System.out.println("잘못 사용한 @ExceptionTest: " + m);
                }
            }
        }

        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
