package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class QuestionNo10768 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(inputStreamReader.readLine());
        int day = Integer.parseInt(inputStreamReader.readLine());

        LocalDate specialDay = LocalDate.of(2015, 2, 18);
        LocalDate date = LocalDate.of(2015, month, day);

        if (date.isEqual(specialDay)) {
            System.out.println("Special");
        } else if (date.isAfter(specialDay)) {
            System.out.println("After");
        } else {
            System.out.println("Before");
        }
    }
}
