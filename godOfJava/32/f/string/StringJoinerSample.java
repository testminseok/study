package f.string;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerSample {
    public static void main(String[] args) {
        StringJoinerSample sample = new StringJoinerSample();
        sample.checkJoiner();
    }

    private void checkJoiner() {
        String[] strings = new String[]{"check", "Joiner", "Sample"};

        // OutPut (check,Joiner,Sample)
        System.out.println(basicCode(strings));
        System.out.println(joinerCode(strings));
        System.out.println(lambdaCode(strings));
    }

    private String lambdaCode(String[] strings) {
        return Arrays.stream(strings)
                .collect(Collectors.joining(",","(",")"));
    }

    private String joinerCode(String[] strings) {
        StringJoiner stringJoiner = new StringJoiner(",", "(", ")");
        for (String s : strings) {
            stringJoiner.add(s);
        }

        return stringJoiner.toString();
    }

    private String basicCode(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");

        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]);
            stringBuilder.append(",");
        }

        String returnValue = stringBuilder.substring(0, stringBuilder.lastIndexOf(","));

        return returnValue + ")";
    }
}
