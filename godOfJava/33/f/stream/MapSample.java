package f.stream;

import java.util.ArrayList;
import java.util.List;

public class MapSample {
    public static void main(String[] args) {
        MapSample sample = new MapSample();

        List<Integer> intList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            intList.add(i);
        }

        sample.multiplyWithStream(intList);
    }

    private void multiplyWithStream(List<Integer> intList) {
        intList.stream().map(integer -> integer * 3).forEach(System.out::println);
    }
}
