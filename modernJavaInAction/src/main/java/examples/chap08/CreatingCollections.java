package examples.chap08;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingCollections {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<>();
        friends.add("Raphael");
        friends.add("Olivia");
        friends.add("Thibaut");

        // Arrays.asList 팩토리 메소드 - (수정 가능, 추가 불가능)
        List<String> friends2 = Arrays.asList("Raphael", "Olivia", "Thibaut");

        // (수정, 추가 가능)
        Set<String> friends3 = new HashSet<>(Arrays.asList("Raphael", "Olivia", "Thibaut"));

        // Set.of - (추가 가능, 중복 값 불가능)
        Set<String> friends4 = Stream.of("Raphael", "Olivia", "Thibaut")
                .collect(Collectors.toSet());

        // List.of - (수정 불가능, 추가 불가능)
        List<String> friends5 = List.of("Raphael", "Olivia", "Thibaut");

        // Set.of - (추가 불가능, 중복 값 불가능)
        Set<String> friends6 = Set.of("Raphael", "Olivia", "Thibaut");

        // Map.of (key1,value1,key2,value2)
        Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);

        // Map.ofEntries
        Map<String, Integer> ageOfFriends2 =
                Map.ofEntries(
                        Map.entry("Raphael", 30),
                        Map.entry("Olivia", 25),
                        Map.entry("Thibaut", 26));
    }
}
