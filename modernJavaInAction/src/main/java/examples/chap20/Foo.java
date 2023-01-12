package examples.chap20;

import java.util.stream.IntStream;

public class Foo {
    /*
    * 아래 코드와 동일한 결과의 스칼라 코드
    * object Beer {
    *   def main(args: Array[String]) {
    *       2 to 6 foreach { n => println(s"Hello ${n} bottles of beer") }
    *   }
    * }
    * */
    public static void main(String[] args) {
        IntStream.rangeClosed(2, 6)
                .forEach(n -> System.out.println("Hello " + n + " bottles of beer"));

    }
}
