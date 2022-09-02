package d.util;

import java.util.StringTokenizer;

public class StringTokenizerSample {
    public static void main(String[] args) {
        /*
        * StringTokenizer 보단 String split 메소드를 사용하는것을 권장한다.
        * 아주 큰 문자열을 다루고, 앞에 있는 일부 값만 처리해야 할 때에는 split() 메소드를 사용하면 메모리낭비가 심하므로,
        * StringTokenizer 를 사용하는것이 더 나을 수 있다.
        * */
        StringTokenizerSample sample = new StringTokenizerSample();
        String data = "This is a basic java book";
        sample.parseString(data);
        sample.parseStringWithSplit(data);
    }

    private void parseStringWithSplit(String data) {
        String[] splitString = data.split("\\s");
        for (String tempData : splitString) {
            System.out.printf("[%s] \n", tempData);
        }
    }

    private void parseString(String data) {
        StringTokenizer stringTokenizer = new StringTokenizer(data, " ");

        while (stringTokenizer.hasMoreTokens()) {
            System.out.println("[" + stringTokenizer.nextToken() + "]");
        }
    }
}
