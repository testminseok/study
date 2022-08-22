package d.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetSample {
    public static void main(String[] args) {
        SetSample sample = new SetSample();
        String[] cars = new String[] {
                "Tico", "Sonata", "BMW", "Benz",
                "Lexus", "Mustang", "Grandeure",
                "The Beetle", "Mini Cooper", "i30",
                "BMW", "Lexus", "Carnibal", "SM5",
                "SM7", "SM3", "Tico"
        };
        System.out.println(sample.getCarKinds(cars));
    }

    public int getCarKinds(String[] cars) {
        if (cars == null || cars.length == 0) return 0;
        if (cars.length == 1) return 1;

        Set<String> set = new HashSet<>();

        for (String car : cars) {
            set.add(car);
        }

        printCarSet(set);

        return set.size();
    }

    public void printCarSet(Set<String> set) {
        for (String temp : set) {
            System.out.print(temp + " ");
        }
    }
}
