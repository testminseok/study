package chapter02.item45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {
    public static void main(String[] args) throws IOException {
        goodCode(args);
        badCode(args);
        perfectCode(args);
    }

    // 스트림을 적절히 활용하면 깔끔하고 명료해진다.
    private static void perfectCode(String[] args) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(Collectors.groupingBy(word -> alphabetize(word)))
                    .values()
                    .stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(System.out::println);
        }
    }

    // 스트림을 과하게 사용했다. - 따라 하지 말 것!
    private static void badCode(String[] args) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try (Stream<String> words = Files.lines(dictionary)) {
            /*
            * Collectors.groupingBy 메서드는 스트림의 모든 원소를 수집해서 맵으로 반환한다.
            * 이때 맵의 키는 그룹의 구분자가 되고, 값은 그룹의 원소들이 된다.
            * Collectors.groupingBy 메서드는 두 번째 인수로 Collector를 받는다.
            * Collector는 스트림의 원소들을 어떤 식으로 합칠지를 정의한다.
            * Collectors.groupingBy 메서드는 스트림의 원소들을 그룹화한 다음, 각 그룹에 Collector를 적용해서
            * 그룹의 원소들을 어떤 식으로 합칠지를 정의한다.
            * */
            words.collect(
                            Collectors.groupingBy(word -> word.chars().sorted()
                                    .collect(StringBuilder::new,
                                            (sb, c) -> sb.append((char) c),
                                            StringBuilder::append).toString()))
                    .values()
                    .stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + ": " + group)
                    .forEach(System.out::println);
        }
    }

    // 사전 하나를 훑어 원소 수가 많은 아나그램 그룹들을 출력한다.
    private static void goodCode(String[] args) throws FileNotFoundException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
            }
        }

        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + ": " + group);
            }
        }
    }

    private static String alphabetize(String word) {
        char[] a = word.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
