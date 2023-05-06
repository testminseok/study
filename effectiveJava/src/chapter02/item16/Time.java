package chapter02.item16;

public class Time {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;

    /*
    * public 클래스의 필드가 불변이라면 직접 노출할 때의 단점이 조금은 줄어들지만,
    * API 를 변경하지 않고는 표현 방식을 바꿀 수 없고, 필드를 읽을 때 부수 잡업을 수행할 수 없다는 단점은 여전하다.
    * 단 불변식은 부장할 수 있게 된다. (ex. hour 필드는 0~23 사이의 값을 가진다.)
    * */
    public final int hour;
    public final int minute;

    public Time(int hour, int minute) {
        if (hour < 0 || hour >= HOURS_PER_DAY) {
            throw new IllegalArgumentException("시간: " + hour);
        }
        if (minute < 0 || minute >= MINUTES_PER_HOUR) {
            throw new IllegalArgumentException("분: " + minute);
        }
        this.hour = hour;
        this.minute = minute;
    }
}
