package examples.chap12;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class DateTimeExamples {

    private static final LocalDate DATE = LocalDate.of(2022, 12, 01);

    private static final LocalTime TIME = LocalTime.of(17, 40, 00); // 13:45:20

    public static void main(String[] args) {
        /*
        * LocalDate, LocalTime, LocalDateTime, Instant 는 모두 Temporal interface 를 구현한다.
        * Temporal interface 는 특정 시간을 모델링하는 객체의 값을 어떻게 읽고 조작할지 정의한다.
        * */
        localDate();
        localTime();
        localDateTime();
        instant();

        /*
        * 두 시간 객체 사이의 지속시간 Duration 은 초와 나노초로 시간단위를 표현하므로 between 에 LocalDate 를 사용할 수 없다
        * Period 의 between 으로 LocalDate 의 차이를 확인할 수 있다.
        * */
        duration();
        period();
        withAttribute();
        withRelativeAttribute();
        temporalAdjusters();
    }

    private static void temporalAdjusters() {
        LocalDate date1 = LocalDate.of(2022, 12, 03); // 2022-12-03
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY)); // 2022-12-04
        LocalDate date3 = date2.with(lastDayOfMonth()); // 2022-12-31

        System.out.println(date3);
    }

    private static void withRelativeAttribute() {
        LocalDate date1 = LocalDate.of(2022, 12, 03); // 2022-12-03
        LocalDate date2 = date1.plusWeeks(1); // 2022-12-10
        LocalDate date3 = date2.minusYears(6); // 2016-12-10
        LocalDate date4 = date3.plus(6, ChronoUnit.MONTHS); // 2017-06-10

        System.out.println(date4);
    }

    private static void withAttribute() {
        LocalDate date1 = LocalDate.of(2022, 12, 03); // 2022-12-03
        LocalDate date2 = date1.withYear(2023); // 2023-12-03
        LocalDate date3 = date2.withDayOfMonth(01); // 2023-12-01
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 1); // 2023-01-01

        System.out.println(date4);
    }

    private static void period() {
        Period between = Period.between(
                LocalDate.of(2022, 12, 02),
                LocalDate.of(2022, 12, 12));

        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

        System.out.println(between.getYears()); // 0
        System.out.println(between.getMonths()); // 0
        System.out.println(between.getDays()); // 10

        System.out.println(tenDays); // P10D
        System.out.println(threeWeeks); // P21D
        System.out.println(twoYearsSixMonthsOneDay); // P2Y6M1D
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

        System.out.println(threeMinutes); // PT3M
        System.out.println(threeMinutes2); // PT3M
        System.out.println(duration.getSeconds()); // -10
        System.out.println(duration2.getSeconds()); // 282376726
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
