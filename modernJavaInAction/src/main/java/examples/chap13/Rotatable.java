package examples.chap13;

public interface Rotatable {

    void setRotationAngle(int angleDegrees);

    int getRotationAngle();

    default void rotateBy(int angleDegrees) {
        setRotationAngle((getRotationAngle() + angleDegrees) % 360);
    }
}
