package chapter02;

import chapter02.item34.Planet;

public class WeightTable {
    public static void main(String[] args) {
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet planet : Planet.values()) {
            System.out.printf("%s 에서의 무게는 %f 이다.%n", planet, planet.surfaceWeight(mass));
        }
    }
}
