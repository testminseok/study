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

        // Arrays.asList 팩토리 메소드 - 요소의 갱신은 되지만 크기가 고정되어 있으므로, 추가는 되지 않는다.
        List<String> friends2 = Arrays.asList("Raphael", "Olivia", "Thibaut");

        // set 이라는 팩토리 메소드는 없으므로 HashSet 의 생성자를 사용
        Set<String> friends3 = new HashSet<>(Arrays.asList("Raphael", "Olivia", "Thibaut"));


        Set<String> friends4 = Stream.of("Raphael", "Olivia", "Thibaut")
                .collect(Collectors.toSet());

        // List.of 또한 추가가 불가능하다.
        List<String> friends5 = List.of("Raphael", "Olivia", "Thibaut");

        // Set.of 추가가 불가능하며, 중복된 값이 있을경우도 IllegalArgumentException 를 발생시킨다.
        Set<String> friends6 = Set.of("Raphael", "Olivia", "Thibaut");

    }
}
