package chapter02.item33;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 컨테이너 대신 키를 매개변수화한 다음, 컨테이너에 값을 넣거나 뺼 때 매개변수화한 키를 함께 제공하면
 * 제네릭 타입 시스템이 값의 타입이 키와 같음을 보장한다. 이러한 설계 방식을 타입 안전 이종 컨테이너 패턴이라한다.
 * */
public class Favorites {

    private static Map<Class<?>, Object> favorites = new HashMap<>();

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);

        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }

    // 타입안전 이종 컨테이너 패턴 - API
    public <T> void putFavorite(Class<T> type, T instance) {
        // 동적 형변환으로 런타임 타입 안정성 확보
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    // asSubclass 를 사용해 한정적 타입 토큰으로 안전하게 변환한다.
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null; // 비한정적 타입 토큰
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }
}
