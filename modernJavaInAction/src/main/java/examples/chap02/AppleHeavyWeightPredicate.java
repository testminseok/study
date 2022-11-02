package examples.chap02;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(FilteringApple.Apple apple) {
        return 150 < apple.getWeight();
    }
}
