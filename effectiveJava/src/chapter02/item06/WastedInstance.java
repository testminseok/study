package chapter02.item06;

public class WastedInstance {
    public static void main(String[] args) {

        /*
        * bad
        * 생성자에 넘겨진 "bikini" 자체가 이 생성자로 만들어내려는 String 과
        * 기능적으로 완전히 똑같다. 그러므로, 쓸데없는 String 인스턴스를 만들지 말자.
        * */
        String s = new String("bikini");

        // good
        String s2 = "bikini";

        // bad
        boolean bool = new Boolean("true");

        /*
        * good
        * 생성자는 호출할 때마다 새로운 객체를 만들지만, 팩터리 메서드는 전혀 그렇지 않다.
        *
        * */
        boolean bool2 = Boolean.valueOf("true");

    }

    private static long sum() {
        /*
        * bad
        * Long 은 long 보다 무거운 객체이다.
        * sum 에 i 를 더할때마다 Long 으로 박싱되므로, 성능저하가 일어난다.
        * */
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static boolean isRomanNumeral(String s) {
        /*
        * bad
        * String.matches 는 정규표현식으로 문자열 형태를 확인하는 가장 쉬운 방법이지만,
        * 성능이 중요한 상황에서 반복해 사용하기엔 적합하지 않다.
        * */
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" +
                "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    private static class RomanNumerals {

        private static final String ROMAN = "^(?=.)M*(C[MD]|D?C{0,3})" +
                "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";

        /*
        * good
        * String.matches 를 사용하지 않고, 간단한 문자열 검사로 대체할 수 있다.
        * */
        static boolean isRomanNumeral(String s) {
            return s.matches(ROMAN);
        }
    }
}
