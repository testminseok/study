package chapter09.item63;

/**
 * 원칙은 간단하다. 선으에 신경 써야 한다면 많은 문자열을 연결할 때는 문자열 연결 연산자 (+)를 피하자
 * 대신 StringBuilder 의 append 메서드를 사용하라. 문자 배열을 사용하거나 문자열을 (연결하지 않고) 하나씩 처리하는 방법도 있다.
 * */
public class StringConnectionIsSlow {
    private static final int LINE_WIDTH = 10;

    public static void main(String[] args) {
        StringConnectionIsSlow stringConnectionIsSlow = new StringConnectionIsSlow();
        // 시간 측정
        long start = System.currentTimeMillis();
        stringConnectionIsSlow.statement();
        long end = System.currentTimeMillis();
        System.out.println("String 연결 시간: " + (end - start) + "ms"); // 5987ms

        start = System.currentTimeMillis();
        stringConnectionIsSlow.statement2();
        end = System.currentTimeMillis();
        System.out.println("StringBuilder 연결 시간: " + (end - start) + "ms"); // 9ms
    }

    // 문자열 연결을 잘못 사용한 예 - 느리다.
    public String statement() {
        String result = "";
        for (int i = 0; i < numItems(); i++) {
            result += lineForItem(i); // 문자열 연결
        }
        return result;
    }

    public String statement2() {
        StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);
        for (int i = 0; i < numItems(); i++) {
            b.append(lineForItem(i));
        }
        return b.toString();
    }

    private String lineForItem(int i) {
        return i + "number";
    }

    private int numItems() {
        return 100_000;
    }
}
