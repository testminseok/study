package chapter09.item57;

/**
 * 지역변수의 범위를 줄이는 가장 강력한 기법은 역시 '가장 처음 쓰일 때 선언하기'다.
 * 지역변수 범위를 최소화하는 마지막 방법은 메서드를 작게 유지하고 한가지 기능에 집중하는것이다.
 * */
public class MinimizeLocalVariable {
    public static void main(String[] args) {

        int a = 0; // bad
        int b = 0; // bad

        // ... code


        /*
        * 지역변수의 범위를 줄이는 가장 강력한 기법은 역시 '가장 처음 쓰일 때 선언하기'다.
        * */
        // int a = 0; // good
        // int b = 0; // good
        int c = a + b;

        /*
        * 거의 모든 지역변수는 선언과 동시에 초기화 해야한다.
        * 초기화에 필요한 정보가 충분하지 않다면 충분해질 때까지 선언을 미뤄야 한다.
        * try-catch 문은 이 규칙의 합당한 예외다.
        * */
        String d = null; // bad


    }
}
