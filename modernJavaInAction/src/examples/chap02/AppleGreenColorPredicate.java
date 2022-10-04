package examples.chap02;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(FilteringApple.Apple apple) {
        return Color.GREEN == apple.getColor();
    }
}
