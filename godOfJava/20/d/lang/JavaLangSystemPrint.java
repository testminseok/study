package d.lang;

public class JavaLangSystemPrint {
    public static void main(String[] args) {
        JavaLangSystemPrint sample = new JavaLangSystemPrint();
        sample.printStreamCheck();
        sample.printNull();
    }

    public void printStreamCheck() {
        byte b = 127;
        short s = 32767;

        System.out.println(b);
        System.out.println(s);

        printInt(b);
        printInt(s);
    }

    public void printInt(int value) {
        System.out.println(value);
    }

    public void printNull() {
        Object obj = null;

        /*
            println() 에서 Object type 은 String.valueOf() 메소드로 호출하고 있기 때문에 오류가 발생하지 않는다.
            toString 으로 값을 출력하기보단 String.valueOf() 가 더 안전하다.
         */
        System.out.println(obj);
        System.out.println(obj + " is object's value");
    }
}