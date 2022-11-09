package examples.chap08;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CacheExample {
    private static List<String> LINES = Arrays.asList(
            " Nel   mezzo del cammin  di nostra  vita ",
            "mi  ritrovai in una  selva oscura",
            " che la  dritta via era   smarrita "
    );

    public static void main(String[] args) {
        Map<String, byte[]> dataToHash = new HashMap<>();

        LINES.forEach(line -> {
            dataToHash.computeIfAbsent(line, CacheExample::calculateDigest);
        });

        dataToHash.forEach((line, hash) ->
                System.out.printf("%s -> %s%n", line,
                        new String(hash).chars()
                                .map(i -> i & 0xff)
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining(", ", "[", "]"))));
    }

    private static byte[] calculateDigest(String key) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
    }
}
