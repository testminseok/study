package c.annotation;

import java.lang.reflect.Method;

public class UserAnnotationCheck {

    public static void main(String[] args) {
        /*
        * 자바에서 어노테이션을 확장하는것은 불가능하다 (상속불가)
        * */
        UserAnnotationCheck sample = new UserAnnotationCheck();
        sample.checkAnnotations(UserAnnotationSample.class);
    }

    public void checkAnnotations(java.lang.Class useClass) {
        /*
        * 자바의 리플랙션을 사용해서 해당 클래스의 정보를 가져올 수 있다.
        * */
        Method[] methods = useClass.getDeclaredMethods();
        for (Method method : methods) {
            UserAnnotation annotation = method.getAnnotation(UserAnnotation.class);

            if (annotation != null) {
                int number = annotation.number();
                String text = annotation.text();

                System.out.println(method.getName() + "() : number = " + number + " text = " + text);
            } else {
                System.out.println(method.getName() + "() : annotation is null.");
            }
        }
    }
}
