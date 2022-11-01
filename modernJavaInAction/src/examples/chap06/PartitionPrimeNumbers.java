package examples.chap06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class PartitionPrimeNumbers {
    public static void main(String[] args) {
        System.out.println(partitionPrimes(100));
        System.out.println(partitionPrimesWithCustomCollector(100));
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.range(2, n).boxed()
                .collect(partitioningBy(PartitionPrimeNumbers::isPrime));
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.range(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector2(int n) {
        return IntStream.range(2, n).boxed()
                .collect(
                        () -> new HashMap<Boolean, List<Integer>>() {{
                            put(true, new ArrayList<Integer>());
                            put(false, new ArrayList<Integer>());
                        }},
                        (acc, candidate) -> acc.get(isPrime(acc.get(true), candidate)).add(candidate),
                        (map1, map2) -> {
                            map1.get(true).addAll(map2.get(true));
                            map1.get(false).addAll(map2.get(false));
                        }
                );
    }

    // 소수인지 판별
    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        /*return primes.stream()
                .takeWhile(i -> i <= candidateRoot)
                .noneMatch(i -> candidate % i == 0);*/
        return takeWhile(primes, i -> i <= candidateRoot).stream()
                .noneMatch(i -> candidate % i == 0);
    }

    public static <T> List<T> takeWhile(List<T> sortedList, Predicate<T> predicate) {
        int i = 0;
        for (T element : sortedList) {
            if (!predicate.test(element)) { // 리스트의 현재 항목이 프레디케이트를 만족하는지 확인
                return sortedList.subList(0, i); // 만족하지 않으면 현재 검사한 항목의 이전 항목 하위 리스트를 반환
            }
            i++;
        }
        return sortedList;
    }
}
