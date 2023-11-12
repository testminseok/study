package baekjoon;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class QuestionNo10699 {
    public static void main(String[] args) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
