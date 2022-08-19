package d.generic.practice;

public class MaxFinder {
    public static void main(String[] args) {
        MaxFinder sample = new MaxFinder();
        sample.testGetMax();
        sample.testGetMin();
    }

    public void testGetMin() {
        System.out.println(getMin(1, 2, 3));
        System.out.println(getMin(3, 1, 2));
        System.out.println(getMin(2, 3, 1));
        System.out.println(getMin("a", "b", "c"));
        System.out.println(getMin("b", "c", "a"));
        System.out.println(getMin("a", "b", "c"));
    }

    public void testGetMax() {
        System.out.println(getMax(1, 2, 3));
        System.out.println(getMax(3, 1, 2));
        System.out.println(getMax(2, 3, 1));
        System.out.println(getMax("a", "b", "c"));
        System.out.println(getMax("b", "c", "a"));
        System.out.println(getMax("a", "b", "c"));
    }

    public <T extends Comparable<T>> T getMax(T ...array) {
        T maxT = array[0];

        for (T value : array) {
            if (value.compareTo(maxT) > 0) {
                maxT = value;
            }
        }

        return maxT;
    }

    public <T extends Comparable<T>> T getMin(T ...array) {
        T minT = array[0];

        for (T value : array) {
            if (value.compareTo(minT) < 0) {
                minT = value;
            }
        }

        return minT;
    }
}