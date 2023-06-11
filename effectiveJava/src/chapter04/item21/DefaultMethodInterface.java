package chapter02.item21;

public interface DefaultMethodInterface {

    void versionOneMethod();

    default void versionTwoMethod() {
        System.out.println("default method");
    }
}
