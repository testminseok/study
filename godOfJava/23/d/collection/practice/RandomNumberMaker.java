package d.collection.practice;

import java.security.SecureRandom;
import java.util.HashSet;

public class RandomNumberMaker {
    public static void main(String[] args) {
        RandomNumberMaker maker = new RandomNumberMaker();
        for (int i = 0; i < 10; i++) {
            System.out.println(maker.getSixNumber());
        }
    }

    public HashSet<Integer> getSixNumber() {
        HashSet<Integer> sixNumber = new HashSet<>();

        while (sixNumber.size() < 7) {
            SecureRandom random = new SecureRandom();
            sixNumber.add(random.nextInt(45));
        }

        return sixNumber;
    }
}
