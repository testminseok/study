package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionNo5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));

        final int burgerMenuCount = 3;
        final int drinkMenuCount = 2;
        final int comboMealDiscount = 50;

        List<Integer> burgerPrices = new ArrayList<>();
        for (int i = 0; i < burgerMenuCount; i++) {
            burgerPrices.add(i, Integer.parseInt(inputStreamReader.readLine()));
        }

        List<Integer> drinkPrices = new ArrayList<>();
        for (int i = 0; i < drinkMenuCount; i++) {
            drinkPrices.add(Integer.parseInt(inputStreamReader.readLine()));
        }

        System.out.println(Collections.min(burgerPrices) + Collections.min(drinkPrices) - comboMealDiscount);
    }
}
