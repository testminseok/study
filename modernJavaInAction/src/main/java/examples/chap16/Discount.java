package examples.chap16;

import static examples.chap16.Util.delay;
import static examples.chap16.Util.format;

public class Discount {
    public enum Code {
        NONE(0),
        SILVER(5),
        GOLD(10),
        PLATINUM(15),
        DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " +
                Discount.apply(quote.getPrice(), quote.getDiscountCode()); // 기존 가격에 할인 코드를 적용한다.
    }

    private static double apply(double price, Code discountCode) {
        delay(); // Discount 서비스의 응답 지연을 흉내
        return format(price * (100 - discountCode.percentage) / 100);
    }
}
