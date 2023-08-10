package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionNo25206 {
    enum Rating {
        A_PLUS("A+", 4.5),
        A("A0", 4.0),
        B_PLUS("B+", 3.5),
        B("B0", 3.0),
        C_PLUS("C+", 2.5),
        C("C0", 2.0),
        D_PLUS("D+", 1.5),
        D("D0", 1.0),
        F("F", 0.0),
        P("P", 0.0),
        ;

        private final String rating;
        private final double average;

        Rating(String rating, double average) {
            this.rating = rating;
            this.average = average;
        }

        public double calculate(double score) {
            return score * average;
        }

        public static Rating of(String ratingStr) {
            for (Rating rating : values()) {
                if (ratingStr.equals(rating.rating)) {
                    return rating;
                }
            }
            return Rating.P;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        double total = 0;
        double totalScore = 0;
        while ((str = inputStreamReader.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
            String name = stringTokenizer.nextToken();
            double score = Double.parseDouble(stringTokenizer.nextToken());
            String ratingStr = stringTokenizer.nextToken();

            Rating rating = Rating.of(ratingStr);
            if (Rating.P != rating) {
                totalScore += score;
                total += rating.calculate(score);
            }
        }

        System.out.println(total / totalScore);
    }
}
