package examples.chap16;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService =
                Executors.newCachedThreadPool(); // 스레드 풀에 태스크를 제출할려면 서비스를 만들어야한다.
        Future<Double> future = executorService.submit(new Callable<Double>() { // Callable 을 서비스로 제출한다.
            @Override
            public Double call() throws Exception {
                return doSomeLongComputation(); // 시간이 오래걸리는 작업은 다른 스레드에서 비동기로 실행한다.
            }

            private Double doSomeLongComputation() throws InterruptedException {
                Thread.sleep(1000);
                return 1.0;
            }
        });

        doSomethingElse(); // 비동기 작업을 하는동안 다른작업을 한다.

        try {
            /*
            * 비동기 작업의 결과를 가져온다. 결과가 준비되어 있지 않으면 호출 스레드가 블록된다. 하지만 최대 1초까지만 기다린다.
            * */
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result);
        } catch (ExecutionException e) {
            throw new RuntimeException(e); // 계산 중 예외발생
        } catch (TimeoutException e) {
            throw new RuntimeException(e); // Future 가 완료되기 전에 타임아웃 발생
        }


    }

    private static void doSomethingElse() throws InterruptedException {
        Thread.sleep(2000);
    }
}
