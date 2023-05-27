package chapter02.item37;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum EnumMapPhase {
    SOLID, LIQUID, GAS, PLASMA;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID),
        IONIZE(GAS, PLASMA), DEIONIZE(PLASMA, GAS),
        ;

        private final EnumMapPhase from;
        private final EnumMapPhase to;

        Transition(EnumMapPhase from, EnumMapPhase to) {
            this.from = from;
            this.to = to;
        }

        // 상전이 맵을 초기화한다.
        private static final Map<EnumMapPhase, Map<EnumMapPhase, Transition>> m =
                Stream.of(values()).collect(Collectors.groupingBy(t -> t.from,
                        () -> new EnumMap<>(EnumMapPhase.class),
                        Collectors.toMap(t -> t.to, t -> t,
                                (x, y) -> y, () -> new EnumMap<>(EnumMapPhase.class))));

        public static Transition from(EnumMapPhase from, EnumMapPhase to) {
            return m.get(from).get(to);
        }
    }
}
