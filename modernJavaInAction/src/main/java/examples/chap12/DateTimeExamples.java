package examples.chap12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class DateTimeExamples {
    public static void main(String[] args) {
        localDateInJDK8();
        localTimeInJDK();
    }

    private static void localTimeInJDK() {
        LocalTime time = LocalTime.of(13, 45, 20); // 13:45:20
        LocalTime timeInText = LocalTime.parse("13:45:20");
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        System.out.println(hour); // 13
        System.out.println(minute); // 45
        System.out.println(second); //20

    }

    private static void localDateInJDK8() {
        // 자바 8
        LocalDate date = LocalDate.of(2022, 11, 30);
        int year = date.getYear();
        int yearByTemporalField = date.get(ChronoField.YEAR);
        Month month = date.getMonth();
        int monthByTemporalField = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.getDayOfMonth();
        int dayByTemporalField = date.get(ChronoField.DAY_OF_MONTH);
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

        System.out.println(year); // 2022
        System.out.println(yearByTemporalField); // 2022
        System.out.println(month); // NOVEMBER
        System.out.println(monthByTemporalField); // 11
        System.out.println(day); // 30
        System.out.println(dayByTemporalField); // 30
        System.out.println(dow); // WEDNESDAY
        System.out.println(len); // 30 (11월의 일수)
        System.out.println(leap); // false - 윤년이 아님
    }
}
