package d.util;

import java.util.Random;

public class RandomSample {
    public static void main(String[] args) {
        RandomSample sample = new RandomSample();
        int randomCount = 10;
        sample.generateRandomNumbers(randomCount);
    }

    private void generateRandomNumbers(int randomCount) {
        Random random = new Random();
        for (int i = 0; i < randomCount; i++) {
            System.out.print(random.nextInt(100) + " ,");
        }
    }
}
