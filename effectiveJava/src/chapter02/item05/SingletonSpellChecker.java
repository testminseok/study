package chapter02.item05;

import java.util.List;

/**
 * 사용하는 자원에 따라 동작이 달라지는 클래스에는 정적 유틸리티 클래스나
 * 싱글턴 방식이 적합하지 않다.
 * */
public class SingletonSpellChecker {
    private static final Lexicon dictionary = new Lexicon();

    private SingletonSpellChecker() {}

    public static SingletonSpellChecker INSTANCE = new SingletonSpellChecker();

    public boolean isValid(String word) {
        return true;
    }

    public List<String> suggestions(String typo) {
        return null;
    }

    private static class Lexicon {
    }
}
