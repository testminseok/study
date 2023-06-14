package chapter08.item54;

import java.util.ArrayList;
import java.util.List;

/**
 * null 이 아닌, 빈 배열이나 컬렉션을 반환하라. null 을 반환하는 API 는 사용하기 어렵고 오류 처리 코드도 늘어난다.
 * 그렇다고 성능이 좋은 것도 아니다.
 * */
public class ReturnAnEmptyCollectionOfNull {

    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
    private final List<Cheese> cheesesInStock = new ArrayList<>();

    /**
     * 컬렉션이 비었으면 null 을 반환한다. - 따라 하지 말 것!
     * @return 매장 안의 모든 치즈 목록을 반환한다.
     * 단, 재고가 하나도 없다면 null 을 반환한다.
     * */
    public List<Cheese> getCheeses() {
        return cheesesInStock.isEmpty() ? null : new ArrayList<>(cheesesInStock);
    }

    // 빈 컬렉션을 반환하는 올바른 예
    public List<Cheese> getCheeses2() {
        return new ArrayList<>(cheesesInStock);
    }

    // 최적화 - 빈 컬렉션을 매번 새로 할당하지 않도록 했다.
    public List<Cheese> getCheeses3() {
        return cheesesInStock.isEmpty() ? List.of() : new ArrayList<>(cheesesInStock);
    }

    // 길이가 0일 수도 있는 배열을 반환하는 올바른 방법
    public Cheese[] getCheeses4() {
        return cheesesInStock.toArray(new Cheese[0]);
    }

    // 최적화 - 빈 배열을 매번 새로 할당하지 않도록 했다.
    public Cheese[] getCheeses5() {
        return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
    }

    // 나쁜 예 - 배열을 미리 할당하면 성능이 나빠진다.
    public Cheese[] getCheeses6() {
        return cheesesInStock.toArray(new Cheese[cheesesInStock.size()]);
    }

    public static void main(String[] args) {
        ReturnAnEmptyCollectionOfNull returnAnEmptyCollectionOfNull = new ReturnAnEmptyCollectionOfNull();
        List<Cheese> cheeses = returnAnEmptyCollectionOfNull.getCheeses();
        if (cheeses != null && cheeses.contains("cheddar")) {
            System.out.println("원하시는 치즈가 있습니다");
        }
    }

    private class Cheese {
    }
}
