package chapter02.item39;

import chapter02.item39.annotation.Test;

import java.lang.reflect.Method;

public class TestAnnotationProcessor {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName("chapter02.item39.TestAnnotationSample");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("테스트 %s 실패: %s %n", m, ex.getCause());
                }
            }
        }

        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
