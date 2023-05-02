package chapter02.item13;

public class CloneableExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        final short areaCode = 707;
        final short prefix = 867;
        final short lineNum = 5309;

        PhoneNumber phoneNumber = new PhoneNumber(areaCode, prefix, lineNum);
        PhoneNumber clone = phoneNumber.clone();

        System.out.println(phoneNumber != clone);
        System.out.println(phoneNumber.getClass() == clone.getClass());
        System.out.println(phoneNumber.equals(clone));


    }
}
