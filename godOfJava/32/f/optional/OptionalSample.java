package f.optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalSample {
    public static void main(String[] args) throws Exception {
        /*
        * Optional 을 사용하는 이유는 보다 쉬운 null check 로 NullPointException 을 예방하기 위함이다.
        * Optional 객체는 비용이 비싸기 때문에 무분별한 사용은 하지말아야한다.
        * */
        OptionalSample sample = new OptionalSample();
        sample.createOptionalObjects();
        sample.checkOptionalData();
        sample.getOptionalData();
    }

    private void getOptionalData() throws Exception {
        Optional<String> optional = Optional.ofNullable("data");
        String defaultValue = "default";
        String result1 = optional.get();
        String result2 = optional.orElse(defaultValue);

        /*
         * Supplier 인터페이스는 람다 표현식에서 사용하려는 용도로 만들어졌다.
         * */
        Supplier<String> stringSupplier = new Supplier<String>() {
            @Override
            public String get() {
                return "GodOfJava";
            }
        };

        String result3 = optional.orElseGet(stringSupplier);
        String result4 = optional.orElseThrow(() -> new Exception());
    }

    private void checkOptionalData() {
        System.out.println(Optional.of("present").isPresent());
        System.out.println(Optional.ofNullable(null).isPresent());
    }

    private void createOptionalObjects() {
        Optional<String> emptyString = Optional.empty(); // 빈 Optional 객채를 생성
        
        String common = null;
        Optional<String> nullableString = Optional.ofNullable(common); // null 값이 있을 수 있는 Optional 객체 생성

        String string = "string";
        Optional<String> ofString = Optional.of(string); // 값이 들어있는 Optional 객체 생성
    }
}
