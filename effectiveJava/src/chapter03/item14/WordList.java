package chapter03.item14;

import java.util.Set;
import java.util.TreeSet;

public class WordList {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        s.add("one");
        s.add("two");
        s.add("three");
        System.out.println(s);
    }
}
