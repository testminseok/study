package examples.chap11;

import java.util.Optional;

public class PersonV2 {
    private Optional<CarV2> car;

    private int age;

    public Optional<CarV2> getCar() {
        return car;
    }

    public int getAge() {
        return age;
    }
}
