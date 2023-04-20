package chapter02.item02;

/**
 * 자바 빈즈 패턴에서는 객체 하나를 만들려면 메서드 여러 개 호출해야 하고
 * 객체가 완전히 생성되기 전까지는 일관성이 무너진 상태에 놓이게 된다.
 *
 * 자바 빈즈 패턴에서는 클래스를 불변으로 만들 수 없으며, 스레드 안전성을 얻으려면 추가적인 작업을 해야한다.
 * */
public class NutritionFactsForJavaBeans {
    private int servingSize = -1; // (ml, 1회 제공량) 필수 기본값 없음
    private int servings = -1; // (회, 총 n회 제공량) 필수 기본값 없음
    private int calories = 0; // (1회 제공량당) 선택 기본값 0
    private int fat = 0; // (g/1회 제공량) 선택 기본값 0
    private int sodium = 0; // (mg/1회 제공량) 선택 기본값 0
    private int carbohydrate = 0; // (g/1회 제공량) 선택 기본값 0

    public NutritionFactsForJavaBeans() {
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
