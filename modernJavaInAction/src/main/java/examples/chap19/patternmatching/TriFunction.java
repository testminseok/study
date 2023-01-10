package examples.chap19.patternmatching;

@FunctionalInterface
public interface TriFunction<S, T, U, R> {
    R apply(S s, T t, U u);
}
