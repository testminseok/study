package com.software.basic.problem.string;

/**
 * 4-6 StringBuilder/StringBuffer 사용시 주의해야하는 실수
 */
public class WrongStringBuilderUseExample {

    /*
    * StringBuilder 와 StringBuffer 를 클래스 멤버 변수로 사용하면
    * 장시간 클래스 인스턴스가 생존할 수록 메모리 누수의 가능성도 높아진다.
    *
    * why
    * 해당 클래스가 오랫동안 생존하거나 객체가 정상적으로 관리되지 않아 불필요하게 크기가 커진다면
    * 메모리 누수의 주된 원이이 될 수 있다.
    * */
    private StringBuilder stringBuilder = new StringBuilder();
    private StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();

        /*
        * append 를 연결해서 사용하면 메소드 체인이 발생하여 메모리 누수가 발생할 가능성이 있다.
        *
        * why?
        * 모든 메소드가 하나의 체인으로 연결되며 이 메소드에 사용된 모든 인자도 연결되므로 비효율적인 메모리 점유가 발생하며,
        * 성능상 그리 좋지 않다.
        * 메소드 체인으로 연결된 메소드는 결국 연결된 모든 메소드의 스택이 종료되기 전까지 점유한 메모리를 반환하지 않으며,
        * 메소드에 전달된 인자 또한 모든 메소드가 종료되기 전까지 메모리 상에 유지된다.
        * */
        builder.append("abc").append("def").append("123");

        /*
        * StringBuilder 에서도 자체적인 length 메소드를 제공한다.
        * 단순히 길이만을 확인하기 위해 toString 을 사용하는것은 불필요한 인스턴스만 생성하게 된다.
        * */
        System.out.println("StringBuilder 의 길이는 : " + builder.toString().length());

        StringBuffer buffer = new StringBuffer();

        /*
        * append 를 연결해서 사용하면 메소드 체인이 발생하여 메모리 누수가 발생할 가능성이 있다.
        * */
        buffer.append("<xml>").append("<head>").append("</head>");

        /*
        * 연결된 문자열을 분리해서 입력하는것은 비효율적이다.
        * */
        buffer.append("Hello").append(" ").append("World");

        /*
         * StringBuffer 에서도 자체적인 length 메소드를 제공한다.
         * 단순히 길이만을 확인하기 위해 toString 을 사용하는것은 불필요한 인스턴스만 생성하게 된다.
         * */
        System.out.println("StringBuffer 의 길이는 : " + buffer.toString().length());

    }
}
