package baekjoon;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class QuestionNo14645 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("UTC"));

        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy\nMM\ndd"));
        System.out.println(format);

    }
}
