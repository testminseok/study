package d.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatSample {

    private static final int DATE = 1;
    private static final int TIME = 2;
    private static final int DATE_TIME = 3;

    public static void main(String[] args) {
        DateFormatSample sample = new DateFormatSample();
        sample.checkDateformat();
        sample.checkSimpleDateFormat();
    }

    private void checkSimpleDateFormat() {
        Date currentDate = new Date(1328054400000L);
        String pattern = "yyyy/MM/dd hh:mm";
        printDateWithPattern(currentDate, pattern);

        pattern = "MMM d일 EEE";
        printDateWithPattern(currentDate, pattern);
    }

    private void printDateWithPattern(Date currentDate, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println("pattern : " + pattern + ", result : " + simpleDateFormat.format(currentDate));
    }

    private void checkDateformat() {
        Date currentDate = new Date(1328054400000L);
        int style = DateFormat.DEFAULT;
        int formatType = DATE_TIME;

        printFormattedDateTime(currentDate, Locale.KOREA, style, formatType);
        printFormattedDateTime(currentDate, Locale.US, style, formatType);
        printFormattedDateTime(currentDate, Locale.FRANCE, style, formatType);
        printFormattedDateTime(currentDate, Locale.GERMANY, style, formatType);
    }

    private void printFormattedDateTime(Date date, Locale locale, int style, int formatType) {
        DateFormat format;

        switch (formatType) {
            case DATE:
                format = DateFormat.getDateInstance(style, locale);
                break;
            case TIME:
                format = DateFormat.getTimeInstance(style, locale);
                break;
            case DATE_TIME:
                format = DateFormat.getDateTimeInstance(style, style, locale);
                break;
            default:
                return;
        }
        System.out.println(locale.getCountry() + " : " + format.format(date));
    }
}
