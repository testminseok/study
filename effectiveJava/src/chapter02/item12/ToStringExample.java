package chapter02.item12;

public class ToStringExample {
    public static void main(String[] args) {
        final short areaCode = 707;
        final short prefix = 867;
        final short lineNum = 5309;

        PhoneNumber phoneNumber = new PhoneNumber(areaCode, prefix, lineNum);
        System.out.println(phoneNumber);
    }
}
