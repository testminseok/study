package d.lang.practice;

public class NumberObjects {

    public static void main(String[] args) {
        NumberObjects sample = new NumberObjects();
        sample.parseLong("r1024");
        sample.printOtherBase(1024);
    }
    public long parseLong(String data) {
        long result = 0L;
        try {
            result = Long.parseLong(data);
        } catch (NumberFormatException e) {
            System.out.println(data + " is not a number");
            return Long.valueOf(-1);
        } catch (Exception e) {
            System.out.println(data + " is not a number");
            return Long.valueOf(-1);
        }
        return result;
    }

    public void printOtherBase(long value) {
        System.out.println(Long.toBinaryString(value));
        System.out.println(Long.toHexString(value));
        System.out.println(Long.toOctalString(value));
    }
}