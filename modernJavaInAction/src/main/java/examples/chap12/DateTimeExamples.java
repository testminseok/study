package examples.chap12;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTimeExamples {

    private static final LocalDate DATE = LocalDate.of(2022, 12, 01);

    private static final LocalTime TIME = LocalTime.of(17, 40, 00); // 13:45:20

    public static void main(String[] args) {
        localDate();
        localTime();
        localDateTime();
        instant();
        duration();
    }

    private static void duration() {
        Instant instant = Instant.ofEpochSecond(44 * 365 * 86400);
        Instant now = Instant.now();

        Duration duration = Duration.between(LocalTime.of(17, 40, 10), TIME);
        Duration duration2 = Duration.between(instant, now);

        /*
        * 자신의 인스턴스를 만들 수 있도록 다양한 팩터리 메소드 제공
        * */
        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);

        System.out.println(threeMinutes);
        System.out.println(threeMinutes2);
        System.out.println(duration.getSeconds());
        System.out.println(duration2.getSeconds());
    }

    private static void instant() {
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

    private static void localDateTime() {
        LocalDateTime dateTime1 = LocalDateTime.of(2022, Month.DECEMBER, 01, 17, 40, 00);
        LocalDateTime dateTime2 = LocalDateTime.of(DATE, TIME);
        LocalDateTime dateTime3 = DATE.atTime(17, 40, 00);
        LocalDateTime dateTime4 = DATE.atTime(TIME);
        LocalDateTime dateTime5 = TIME.atDate(DATE);

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

    private static void localTime() {
        LocalTime timeInText = LocalTime.parse("13:45:20");
        int hour = TIME.getHour();
        int minute = TIME.getMinute();
        int second = TIME.getSecond();

        System.out.println(hour); // 13
        System.out.println(minute); // 45
        System.out.println(second); //20

    }

    private static void localDate() {
        // 자바 8
        int year = DATE.getYear();
        int yearByTemporalField = DATE.get(ChronoField.YEAR);
        Month month = DATE.getMonth();
        int monthByTemporalField = DATE.get(ChronoField.MONTH_OF_YEAR);
        int day = DATE.getDayOfMonth();
        int dayByTemporalField = DATE.get(ChronoField.DAY_OF_MONTH);
        DayOfWeek dow = DATE.getDayOfWeek();
        int len = DATE.lengthOfMonth();
        boolean leap = DATE.isLeapYear();

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
