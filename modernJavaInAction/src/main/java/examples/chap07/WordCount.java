package examples.chap07;

import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class WordCount {

    public static final String SENTENCE =
            " Nel   mezzo del cammin  di nostra  vita "
                    + "mi  ritrovai in una  selva oscura"
                    + " che la  dritta via era   smarrita ";

    public static void main(String[] args) {
        System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
        System.out.println("Found " + countWordsByStream(SENTENCE) + " words");
        System.out.println("Found " + countWordsByParallelStream(SENTENCE) + " words");
        System.out.println("Found " + countWordsByCustomSpliterator(SENTENCE) + " words");
    }

    public static int countWordsByCustomSpliterator(String s) {
        return StreamSupport.stream(new WordCounterSpliterator(SENTENCE), true)
                .reduce(new WordCounter(0, true),
                        WordCounter::accumulate,
                        WordCounter::combine)
                .getCounter();
    }

    public static int countWordsByParallelStream(String s) {
        return IntStream.range(0, s.length())
                .mapToObj(s::charAt)
                .parallel()
                .reduce(new WordCounter(0, true),
                        WordCounter::accumulate,
                        WordCounter::combine)
                .getCounter();
    }

    public static int countWordsByStream(String s) {
        return IntStream.range(0, s.length())
                .mapToObj(s::charAt)
                .reduce(new WordCounter(0, true),
                        WordCounter::accumulate,
                        WordCounter::combine)
                .getCounter();
    }

    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;

        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) { // 문자를 하나씩 탐색하다 공백 문자를 만나면 지금까지 탐색한 문자를 단어로 간주한다.
                    counter++;
                }
                lastSpace = false;
            }
        }

        return counter;
    }
}
