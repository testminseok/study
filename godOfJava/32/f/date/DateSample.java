package f.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateSample {
    public static void main(String[] args) {
        DateSample sample = new DateSample();
//        sample.printDayOfWeek();
//        sample.printDayOfWeekOfLocales();
//        sample.check1();
        sample.check2();
    }

    private void check2() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(LocalDateTime.now().format(dateTimeFormatter));
    }

    private void check1() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(zonedDateTime);
        System.out.println(localDate);
        System.out.println(localDateTime);
    }

    private void printDayOfWeekOfLocales() {
        DayOfWeek day = DayOfWeek.MONDAY;
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            System.out.println(locale.getCountry());
            System.out.println(day.getDisplayName(TextStyle.FULL, locale));
            System.out.println(day.getDisplayName(TextStyle.SHORT, locale));
            System.out.println(day.getDisplayName(TextStyle.NARROW, locale));
            System.out.println("----------------------------------");
        }
    }

    private void printDayOfWeek() {
        DayOfWeek[] dayOfWeeks = DayOfWeek.values();
        Locale locale = Locale.getDefault();

        for (DayOfWeek day : dayOfWeeks) {
            System.out.println(day.getDisplayName(TextStyle.FULL, locale));
            System.out.println(day.getDisplayName(TextStyle.SHORT, locale));
            System.out.println(day.getDisplayName(TextStyle.NARROW, locale));
        }
    }
}
