package chapter09.item60;

import java.math.BigDecimal;

/**
 * 정확한 답이 필요한 계산에는 float 나 double 를 피하라. 소수점 추적은 시스템에 맡기고
 * 코딩 시의 불편함이나 성능 저하를 신경 쓰지 않겠다면 BigDecimal 을 사용하라
 * BigDecimal 이 제공하는 여덟 가지 반올림 모드를 이용하여 반올림을 완벽히 제어할 수 있다.
 * 법으로 정해진 반올림을 수행해야하는 비즈니스 계산에서 아주 편리한 기능이다.
 * 반면, 선응이 중요하고 소수점을 직접 추적할 수 있고 숫자가 너무 크지 않다면 int 나 long 을 사용하라.
 * 숫자를 아홉자리 십진수로 표현할 수 있다면 int 를 사용하고, 열여덟 자리 십진수로 표현할 수 있다면 long 을 사용하라.
 * 열여덟 자리 이상 넘어가면 BigDecimal 을 사용해야 한다.
 * */
public class AvoidFloatAndDouble {
    public static void main(String[] args) {
        // 주머니에 1.03달러가 있었는데 그중 42센트를 썼을때 남은 돈은 얼마인가.
        System.out.println(1.03 - 0.42); // 0.6100000000000001

        // 주머니에 1달러가 있었는데 10센트짜리 사탕 9개를 샀을때 남은 돈은 얼마인가.
        System.out.println(1.00 - 9 * 0.10); // 0.09999999999999998

        // 1달러가 있고 선반에 10센트, 20센트, 30센트 ... 1달러짜리의 사탕이 있을때 10센트 부터 하나씩 사면 몇개나 살 수 있는가
        badCode();

        // BigDecimal 을 사용한 해법. 속도가 느리고 쓰기 불편하다
        bigDecimal();

        // 정수 타입을 사용한 해법
        wholeNumber();
    }

    private static void wholeNumber() {
        int itemsBought = 0;
        int funds = 100;
        for(int price = 10; funds >= price; price += 10) {
            funds -= price;
            itemsBought++;
        }

        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(센트): " + funds);
    }

    private static void bigDecimal() {
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought = 0;

        BigDecimal funds = new BigDecimal("1.00");
        for(BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }

        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(달러): " + funds);
    }

    private static void badCode() {
        double funds = 1.00;
        int itemsBought = 0;
        for(double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(달러): " + funds); // 0.3999999999999999
    }
}
