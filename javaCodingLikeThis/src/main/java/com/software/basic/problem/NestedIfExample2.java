package com.software.basic.problem;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 9-1 복잡한 단계의 if 문은 위험하다.
 * - AvoidDeeplyNestedIfStmts : if 문이 3번 중첩되어 있는경수 수정을 권고한다.
 *                              깊게 중첩된 if-then 문은 읽기 어렵고 쉽게 오류가 발생하기 때문에 수정이 필요하다.
 */
public class NestedIfExample2 {
    public static void main(String[] args) {
        Calendar calender = new GregorianCalendar(Locale.KOREA);

        for (int i = 1900; i < calender.get(Calendar.YEAR); i++) {
            if (isLeapYear(i)) {
                System.out.println(i + "년은 윤년입니다.");
            }
        }
    }

    private static boolean isLeapYear(int year) {
        boolean result = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    result = true;
                }
            }
        }

        return result;
    }

    /**
     * 카르노 맵을 사용해 if 문을 간소화
     * 1. 요구된 조건의 명확한 목적을 파악한다.
     * 2. 주어진 조건으로 발생할 수 있는 모든 경우의 수를 나열한다. (진리표)
     * 3. 나열된 조건의 연관관계를 파악해 하나의 집합을 만든다 (카르노 맵)
     * 4. 불필요한 조건을 삭제하고 필요한 조건을 간소화 한다. (불 대수 간소화)
     * */
    private static boolean isLeapYear2(int year) {
        boolean result = false;

        // 4를 약수로 포함하고 100과 400은 약수로 포함하지 않으면 윤년
        if (year % 4 == 0 && year % 100 != 0 && year % 400 != 0) {
            result = true;
        // 4, 100 그리고 400 모두를 야굿로 포함하면 윤년
        } else if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }
}
