package chapter02.item02.example;

public class CalzonePizza extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {

        private boolean sauceInside = false; // 선택 매개변수 - 기본값 false

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        Pizza build() {
            return new CalzonePizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private CalzonePizza(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}
