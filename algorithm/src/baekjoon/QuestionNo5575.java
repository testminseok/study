package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;
import java.util.StringTokenizer;

public class QuestionNo5575 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine());
            int startHour = Integer.parseInt(stringTokenizer.nextToken());
            int startMinute = Integer.parseInt(stringTokenizer.nextToken());
            int startSecond = Integer.parseInt(stringTokenizer.nextToken());
            int endHour = Integer.parseInt(stringTokenizer.nextToken());
            int endMinute = Integer.parseInt(stringTokenizer.nextToken());
            int endSecond = Integer.parseInt(stringTokenizer.nextToken());

            LocalTime start = LocalTime.of(startHour, startMinute, startSecond);
            LocalTime end = LocalTime.of(endHour, endMinute, endSecond);

            Duration duration = Duration.between(start, end);
            builder.append(duration.toHoursPart()).append(" ");
            builder.append(duration.toMinutesPart()).append(" ");
            builder.append(duration.toSecondsPart()).append("\n");
        }

        System.out.println(builder);
    }
}
