package chapter02.item02.example;

import java.util.Objects;

public class NewYorkPizza extends Pizza {
    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        Pizza build() {
            // 하위 클래스의 메서드가 상위 클래스의 메서드가 정의한 반환 타입이 아닌
            // 그 하위 타입을 반환하는 기능을 '공변 반환 타이핑' 이라고 한다.
            return new NewYorkPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NewYorkPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
