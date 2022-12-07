package examples.chap13;

public interface Resizable extends Drawable {

    int getWidth();

    int getHeight();

    void setWidth(int width);

    void setHeight(int height);

    void setAbsoluteSize(int width, int height);

    /*
    * 자바 8에 추가된 interface default method
    *
    * 추상 클래스와 인터페이스의 차이점
    * 1. 클래스는 하나의 클래스만 상송받을 수 있지만 인터페이스는 다중 상속이 가능하다.
    * 2. 추상클래스는 인스턴스변수를 가질 수 있지만 인터페이스는 가질 수 없다.
    * 3. 추상클래스는 생성자를 가질 수 있지만 인터페이스는 가질 수 없다.
    * 4. 존재 목적이 다르다 추상 클래스는 확장이 목적이지만, 인터페이스는 명세에 목적이 있다.
    * */
    default void setRelativeSize(int wFactor, int hFactor) {
        setAbsoluteSize(getWidth() / wFactor, getHeight() / hFactor);
    }

}
