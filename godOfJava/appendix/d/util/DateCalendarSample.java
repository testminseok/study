package d.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateCalendarSample {
    public static void main(String[] args) {
        DateCalendarSample sample = new DateCalendarSample();
        sample.checkDate();
        System.out.println("==========================");
        sample.makeCalendarObject();
        System.out.println("==========================");
        sample.useCalendar();
        System.out.println("==========================");
        sample.addAndRoll(new GregorianCalendar(2000, 11, 31), 10);
    }

    private void addAndRoll(Calendar calendar, int amount) {
        calendar.add(Calendar.DATE, amount);
        printCalendar(calendar);

        calendar.add(Calendar.DATE, -amount);
        printCalendar(calendar);

        calendar.roll(Calendar.DATE, amount); // 일이 증가함에 따라 월이 바뀌는데 roll 은 월은 바뀌지않고 일만 바뀐다.
        printCalendar(calendar);
    }

    private void printCalendar(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.KOREA);
        int date = calendar.get(Calendar.DATE);

        System.out.println(year + "/" + month + "/" + date);
    }

    private void useCalendar() {

        /*
        * Calendar.getInstance() 이렇게 생성하기보단  new GregorianCalendar()로 생성하는게 좋다.
        * GregorianCalendar 은 Calendar 를 상속받아 구현되었다.
        * Calendar.getInstance() 는 별도로 지정하지 않는한 GregorianCalendar 를 반환한다.
        * Java 에서 월은 0월부터 11월 까지 존재한다.
        * */
        Calendar calendar = Calendar.getInstance();
        Calendar greCal = new GregorianCalendar();

        System.out.println(calendar);
        System.out.println(greCal);

        int year = greCal.get(Calendar.YEAR);
        int month = greCal.get(Calendar.MONTH);
        int date = greCal.get(Calendar.DAY_OF_MONTH);

        System.out.println(year + "/" + month + "/" + date);

        String monthKorea = greCal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.KOREA);
        String monthUS = greCal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US);

        System.out.println(monthKorea);
        System.out.println(monthUS);
    }

    private void makeCalendarObject() {
        Calendar calendar = Calendar.getInstance();
        Calendar greCal = new GregorianCalendar();
    }

    private void checkDate() {
        Date date = new Date();
        System.out.println(date);

        long time = date.getTime();
        System.out.println(time);

        date.setTime(0);
        System.out.println(date);
    }
}
