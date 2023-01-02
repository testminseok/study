package examples.chap18;

import java.util.stream.LongStream;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(factorialIterative(5));
        System.out.println(factorialRecursive(5));
        System.out.println(factorialStreams(5));
        System.out.println(factorialTailRecursive(5));
    }

    public static int factorialIterative(int n) {
        int r = 1;
        
        for (int i = 1; i <= n; i++) {
            r *= i;
        }

        return r;
    }

    /**
     * 재귀 방식으로 팩토리얼 계산하기
     * - 함수를 호출할 때마다 호출 스택에 각 호출시 생성되는 정보를 저장할 새로은 스택 프레임이 만들어진다.
     *   즉 재귀 팩토리얼의 입력값에 비례해서 메모리 사용량이 증가한다. 따라서 큰 입력값을 사용하면
     *   StackOverflowError 가 발생한다.
     * */
    static long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }

    /**
     * 스트림으로 팩토리얼 계산하기
     * */
    static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }

    /**
     * 함수형 언어에서는 꼬리 호출 최적화라는 해결책을 제공한다.
     * 하지만 자바는 이와 같은 최적화를 제공하지 않는다.
     * 그럼에도 여전히 고전적인 재귀보다 여러 컴파일러 최적화 여지를 남겨둘 수 있는 꼬리 재귀를 적용하는것이 좋다.
     * */
    static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    private static long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n - 1);
    }
}
