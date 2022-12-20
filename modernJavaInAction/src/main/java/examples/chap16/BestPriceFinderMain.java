package examples.chap16;

public class BestPriceFinderMain {
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(BestPriceFinder.findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
        System.out.println("------------------------------");


        start = System.nanoTime();
        System.out.println(BestPriceFinder.findPricesByParallel("myPhone27S"));
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
        System.out.println("------------------------------");

        start = System.nanoTime();
        System.out.println(BestPriceFinder.findPricesByCompletableFuture("myPhone27S"));
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
        System.out.println("------------------------------");

        start = System.nanoTime();
        System.out.println(BestPriceFinder.findPricesByCompletableFutureAndExecutor("myPhone27S"));
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
        System.out.println("------------------------------");

        start = System.nanoTime();
        System.out.println(BestPriceFinder.findPricesByDiscount("myPhone27S"));
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
        System.out.println("------------------------------");

        start = System.nanoTime();
        System.out.println(BestPriceFinder.findPricesByDiscountAsync("myPhone27S"));
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
        System.out.println("------------------------------");

        start = System.nanoTime();
        BestPriceFinder.printStreamPrices("myPhone27S");
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
        System.out.println("------------------------------");
    }
}
