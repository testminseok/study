package d.format;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatSample {

    private final int DECIMAL = 1;
    private final int ONLY_INTEGER = 2;
    private final int CURRENCY = 3;
    private final int PERCENTAGE = 4;

    public static void main(String[] args) {
        NumberFormatSample sample = new NumberFormatSample();
        sample.checkNumberFormat();
    }

    private void checkNumberFormat() {
//        double number = 3.1415927;
        double number = 846400.1234;
        int[] types = new int[] {DECIMAL, ONLY_INTEGER, CURRENCY, PERCENTAGE};

        for (int i = 0; i < types.length; i++) {
            printFormattedNumber(number, Locale.KOREA, types[i]);
            printFormattedNumber(number, Locale.US, types[i]);
            printFormattedNumber(number, Locale.FRANCE, types[i]);
            printFormattedNumber(number, Locale.GERMANY, types[i]);
            System.out.println("=============================");
        }
    }

    private void printFormattedNumber(double number, Locale locale, int type) {
        NumberFormat format = null;

        switch (type) {
            case DECIMAL:
                format = NumberFormat.getInstance(locale);
                break;
            case ONLY_INTEGER:
                format = NumberFormat.getIntegerInstance(locale);
                break;
            case CURRENCY:
                format = NumberFormat.getCurrencyInstance(locale);
                break;
            case PERCENTAGE:
                format = NumberFormat.getPercentInstance(locale);
                break;
            default:
                return;
        }
        System.out.println(locale.getCountry() + " : " + format.format(number));
    }
}
