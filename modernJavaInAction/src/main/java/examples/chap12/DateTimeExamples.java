package examples.chap12;

import java.time.*;
import java.time.temporal.ChronoField;

public class DateTimeExamples {
    public static void main(String[] args) {
        localDateInJDK8();
        localTimeInJDK8();
        localDateTimeInJDK8();
        instantInJDK8();
    }

    private static void instantInJDK8() {
        // 기계 전용의 유틸리티 - 초와 나노초 정보를 포함한다.
        Instant instant = Instant.ofEpochSecond(3);
        Instant instant1 = Instant.ofEpochSecond(3, 0);
        Instant instant2 = Instant.ofEpochSecond(2, 1_000_000_000);// 2초 이후의 1억 나노초
        Instant instant3 = Instant.ofEpochSecond(4, -1_000_000_000);// 4초 이전의 1억 나노초

        System.out.println(instant);
        System.out.println(instant1);
        System.out.println(instant2);
        System.out.println(instant3);
    }

    private static void localDateTimeInJDK8() {
        LocalDate date = LocalDate.of(2022, 12, 01);
        LocalTime time = LocalTime.of(17, 40, 00); // 13:45:20

        LocalDateTime dateTime1 = LocalDateTime.of(2022, Month.DECEMBER, 01, 17, 40, 00);
        LocalDateTime dateTime2 = LocalDateTime.of(date, time);
        LocalDateTime dateTime3 = date.atTime(17, 40, 00);
        LocalDateTime dateTime4 = date.atTime(time);
        LocalDateTime dateTime5 = time.atDate(date);

        LocalDate date1 = dateTime1.toLocalDate();
        LocalTime time1 = dateTime1.toLocalTime();

        System.out.println(date1); // 2022-12-01
        System.out.println(time1); // 17:40
        System.out.println(dateTime1); // 2022-12-01T17:40
        System.out.println(dateTime2); // 2022-12-01T17:40
        System.out.println(dateTime3); // 2022-12-01T17:40
        System.out.println(dateTime4); // 2022-12-01T17:40
        System.out.println(dateTime5); // 2022-12-01T17:40
    }

    private static void localTimeInJDK8() {
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
