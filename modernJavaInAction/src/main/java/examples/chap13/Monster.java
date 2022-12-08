package examples.chap13;

/*
* 상속받은 인터페이스의 모든 추상메소드를 구현 해야하지만 디폴트 메소드의 구현은 제공할 필요가 없다.
* */
public class Monster implements Rotatable, Moveable, Resizable {

    @Override
    public void draw() {

    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void setAbsoluteSize(int width, int height) {

    }

    @Override
    public void setRotationAngle(int angleDegrees) {

    }

    @Override
    public int getRotationAngle() {
        return 0;
    }
}
