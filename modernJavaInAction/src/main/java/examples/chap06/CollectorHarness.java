package examples.chap06;

import static examples.chap06.PartitionPrimeNumbers.*;

public class CollectorHarness {
    public static void main(String[] args) {
        /*
        * 커스텀 컬렉터로 만든 코드와 partitioningBy 의 성능비교
        * */
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            // partitioningBy - 488, 613
            partitionPrimes(1_000_000); // 백만개의 숫자를 소수와 비소수로 분할한다.
            // collect 를 상속받아 구현한 함수 - 356, 351 약 30% 가량 성능 향상
//            partitionPrimesWithCustomCollector(1_000_000); // 백만개의 숫자를 소수와 비소수로 분할한다.
            // collect 함수를 오버로딩한 함수 - 931, 984
//            partitionPrimesWithCustomCollector2(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) fastest = duration;
        }
        System.out.println("Fastest execution done in " + fastest + " msecs");
    }
}
