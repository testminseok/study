package examples.chap08;

import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

public class WorkingWithCollections {


    public static void main(String[] args) {
        replaceAll();
    }

    public static void replaceAll() {
        collectionList();
        collectionMap();
    }

    private static void collectionMap() {
        Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
        // 자바 8 이전의 Map 의 반복문
        for (Map.Entry<String, Integer> entry : ageOfFriends.entrySet()) {
            String friend = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(friend + " is " + age + " year old");
        }
        // 자바 8
        ageOfFriends.forEach((friend, age) -> System.out.println(friend + " is " + age + " year old"));

        // 맵정렬
        Map<String, String> favouriteMovies = Map.ofEntries(
                Map.entry("Raphael", "Star Wars"),
                Map.entry("Cristina", "Matrix"),
                Map.entry("Olivia", "James Bond"));

        favouriteMovies.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(System.out::println); // 사람의 이름을 알파벳 순으로 스트림 요소를 처리한다.

        // getOrDefault - 키값이 존재하더라도 값이 null 인 상황에서는 null 을 반환한다.
        System.out.println(favouriteMovies.getOrDefault("Olivia", "Matrix")); // James Bond
        System.out.println(favouriteMovies.getOrDefault("Thibaut", "Matrix")); // Matrix

        computingOnMaps();
        removingFromMaps();
        replaceFromMaps();
        mergeFromMaps();

        // 퀴즈 - 아래 코드를 단순화 하시오
        Map<String, Integer> movies = new HashMap<>();
        movies.put("JamesBond", 20);
        movies.put("Matrix", 15);
        movies.put("Harry Potter", 5);
        Iterator<Map.Entry<String, Integer>> iterator = movies.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 10) {
                iterator.remove();
            }
        }

        movies.entrySet().removeIf(entry -> entry.getValue() < 10);
    }

    private static void mergeFromMaps() {

        Map<String, String> family = Map.ofEntries(Map.entry("Cristina", "Matrix"));
        Map<String, String> friends = Map.ofEntries(
                Map.entry("Raphael", "Star Wars"),
                Map.entry("Olivia", "James Bond"),
                Map.entry("Cristina", "James Bond"));
        
        // 자바 8 이전 Map 병합 -> 중복된 키에대해서 따로 처리가 필요하다.
        Map<String, String> everyone = new HashMap<>(family);
        everyone.putAll(friends);
        System.out.println(everyone);

        // 자바 8 이후 Map 병합 -> 중복된 키에 대해서 처리를 같이 할 수 있다.
        Map<String, String> everyone2 = new HashMap<>(family);
        friends.forEach((k, v) -> everyone2.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
        System.out.println(everyone2);

        // 자바 8 이전 Map 병합
        Map<String, Long> moviesToCount = new HashMap<>();
        String movieName = "JamesBond";
        Long count = moviesToCount.get(movieName);
        if (count == null) {
            moviesToCount.put(movieName, 1L);
        } else {
            moviesToCount.put(movieName, count + 1L);
        }
        System.out.println(moviesToCount);

        moviesToCount.clear();

        moviesToCount.merge(movieName, 1L, (key, count2) -> count2 + 1L);
        System.out.println(moviesToCount);
    }

    private static void replaceFromMaps() {
        // replaceAll
        Map<String, String> favouriteMovies = new HashMap<>();
        favouriteMovies.put("Raphael", "Star Wars");
        favouriteMovies.put("Cristina", "Matrix");
        favouriteMovies.put("Olivia", "James Bond");
        favouriteMovies.replaceAll((friend, movie) -> movie.toUpperCase());
        System.out.println(favouriteMovies);
    }

    private static void removingFromMaps() {
        Map<String, List<String>> friendsToMovies = new HashMap<>();

        // 자바 8 이전 - 요소 삭제
        if (friendsToMovies.containsKey("Raphael") &&
                Objects.equals(friendsToMovies.get("key"), "Jack Reacher 2")) {
            friendsToMovies.remove("Raphael");
        }

        // 자바 8 이후 - 요소 삭제
        friendsToMovies.remove("Raphael", "Jack Reacher 2");
    }

    private static void computingOnMaps() {
        Map<String, List<String>> friendsToMovies = new HashMap<>();

        // 자바 8 이전 - 맵에 값을 찾고 값이 없으면 새로운 요소를 삽입
        List<String> movies = friendsToMovies.get("Raphael");
        if (movies == null) {
            movies = new ArrayList<>();
            friendsToMovies.put("Raphael", movies);
        }
        movies.add("Star Wars");
        friendsToMovies.clear();

        // 자바 8 이후 computeIfAbsent 사용
        friendsToMovies.computeIfAbsent("Raphael", (key) -> new ArrayList<>()).add("Star Wars");
    }

    private static void collectionList() {
        List<String> referenceCodes = Arrays.asList("a12", "C14", "b13");

        // 기존 컬렉션을 바꾸는 것이 아니라 새 문자열 컬렉션을 만든다.
        List<String> referenceCodesByStream = referenceCodes.stream()
                .map(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1))
                .collect(Collectors.toList());
        System.out.println("(referenceCodes == referenceCodesByStream) = " + (referenceCodes == referenceCodesByStream));

        // 기존 컬렉션을 바꾸는것은 iterator 를 사용할 수 있다
        for (ListIterator<String> iterator = referenceCodes.listIterator(); iterator.hasNext(); ) {
            String code = iterator.next();
            iterator.set(Character.toUpperCase(code.charAt(0)) + code.substring(1));
        }
        System.out.println(referenceCodes);

        // replaceAll - 기존 컬렉션의 내용을 바꿀 수 있다.
        referenceCodes.replaceAll(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1));
        System.out.println(referenceCodes);
    }
}
