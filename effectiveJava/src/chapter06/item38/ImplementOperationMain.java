package chapter02.item38;

import java.util.Arrays;
import java.util.Collection;

public class ImplementOperationMain {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        test(BasicOperation.class, x, y);
        test(ExtendedOperation.class, x, y);
        test2(Arrays.asList(BasicOperation.values()), x, y);
        test2(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    private static void test2(Collection<? extends Operation> list, double x, double y) {
        for (Operation op : list) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
