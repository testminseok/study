package examples.chap11;

import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class ReadPositiveIntParam {

    @Test
    public void test() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDuration(props, "a"));
        assertEquals(0, readDuration(props, "b"));
        assertEquals(0, readDuration(props, "c"));
        assertEquals(0, readDuration(props, "d"));

        assertEquals(5, readDurationByOptional(props, "a"));
        assertEquals(0, readDurationByOptional(props, "b"));
        assertEquals(0, readDurationByOptional(props, "c"));
        assertEquals(0, readDurationByOptional(props, "d"));
    }

    int readDuration(Properties properties, String name) {
        String value = (String) properties.get(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) {

            }
        }
        return 0;
    }

    int readDurationByOptional(Properties properties, String name) {
        return Optional.ofNullable(properties.getProperty(name))
                .flatMap(this::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

    Optional<Integer> stringToInt(String value) {
        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }
    }

}
