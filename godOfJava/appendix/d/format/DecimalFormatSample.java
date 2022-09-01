package d.format;

import java.text.DecimalFormat;

public class DecimalFormatSample {
    public static void main(String[] args) {
        DecimalFormatSample sample = new DecimalFormatSample();
        sample.checkDecimalFormat();
        sample.checkSubPattern();
    }

    private void checkSubPattern() {
        double number = 1234.5678;
        String pattern = "#,##0.00;(#,##0.00)";
        printFormattedNumber(number, pattern);

        number = -number;
        printFormattedNumber(number, pattern);
    }

    private void checkDecimalFormat() {
        double number = 123.456;
        String pattern = "0,000.00";
        printFormattedNumber(number, pattern);

        number = 1234567.890123;
        printFormattedNumber(number, pattern);

        number = 1;
        printFormattedNumber(number, pattern);

        number = 123.456;
        pattern = "#,###.##";
        printFormattedNumber(number, pattern);

        number = 12324567.890123;
        printFormattedNumber(number, pattern);

        number = 12324567.890123;
        pattern = "#,##0.0#";
        printFormattedNumber(number, pattern);
    }

    private void printFormattedNumber(double number, String pattern) {
        DecimalFormat format = new DecimalFormat(pattern);
        System.out.println("pattern : " + pattern + ", number : " + number + ", result : " + format.format(number));
    }
}
