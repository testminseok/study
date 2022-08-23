package d.collection.practice;

import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Set;

public class RandomNumberStatistics {

    private final int DATA_BOUNDARY = 50;
    private Hashtable<Integer, Integer> hashtable = new Hashtable<>();

    public static void main(String[] args) {
        RandomNumberStatistics randomNumberStatistics = new RandomNumberStatistics();
        randomNumberStatistics.getRandomNumberStatistics();
    }

    public void getRandomNumberStatistics() {
        for (int i = 0; i < 5000; i++) {
            SecureRandom secureRandom = new SecureRandom();
            putCurrentNumber(secureRandom.nextInt(50) + 1);
        }

        printStatistics();
    }

    public void putCurrentNumber(int tempNumber) {
        if (hashtable.containsKey(tempNumber)) {
            hashtable.put(tempNumber, (hashtable.get(tempNumber) + 1));
        } else {
            hashtable.put(tempNumber, 1);
        }
    }

    public void printStatistics() {
        Set<Integer> keySet = hashtable.keySet();
        for (Integer key : keySet) {
            System.out.print(key + " = " + hashtable.get(key) + " ");
            if (key % (10 - 1) == 0) System.out.println();
        }
    }
}
