package com.software.optimize.solution.mutator;

import java.util.Arrays;
import java.util.Date;

/**
 * 11-5 방어복사는 객체를 방어하는 가장 쉬운 방법이다.
 * - MethodReturnsInternalArray : 객체 내부의 배열을 그대로 외부로 반환하는 것을 경고하고 수정을 권고한다.
 *                                내부 배열을 반환하는 것은 소유한 객체 외부에서 요소를 제거하거나 교체할 수 있기 때문에
 *                                객체 캡슐화를 위반하며, 배열의 복사본을 반환하는 것이 안전하다.
 * - ArraysIsStoredDirectly : 외부에서 전달받은 배열을 내부에 직접 저장하는 것을 경고하고 수정을 권고한다.
 *                            배열을 받는 생성자와 메소드는 개체를 복제하고 복사본을 저장해야한다. 이렇게 하면 향후 전달받은 배열이
 *                            직접 변경되었을때 내부 배열에 영향을 주지 않는다.
 * */
public class MutatorExample {
    public static void main(String[] args) {
        MutatorExample example = new MutatorExample();
        example.testConstructor();
        example.testAccessor();
    }

    private void testAccessor() {
        System.out.println("접근자 테스트");
        int[] lotto = {1, 2, 3, 4, 5, 6};
        Date closingDate = new Date();

        LottoController lottoController = new LottoController(closingDate, lotto);
        System.out.println("생성된 로또 정보");
        System.out.println("마감일 : " + lottoController.getClosingDate());
        System.out.println("로또 번호 : " + Arrays.toString(lottoController.getLotto()));

        lottoController.getClosingDate().setDate(lottoController.getClosingDate().getDate() + 1);
        lottoController.getLotto()[0] = 10;
        lottoController.getLotto()[1] = 11;
        lottoController.getLotto()[2] = 12;

        System.out.println("로또 정보를 공격한 이후의 값");
        System.out.println("마감일 : " + lottoController.getClosingDate());
        System.out.println("로또 번호 : " + Arrays.toString(lottoController.getLotto()));
    }

    private void testConstructor() {
        System.out.println("생성자 테스트");
        int[] lotto = {1, 2, 3, 4, 5, 6};
        Date closingDate = new Date();

        LottoController lottoController = new LottoController(closingDate, lotto);
        System.out.println("생성된 로또 정보");
        System.out.println("마감일 : " + lottoController.getClosingDate());
        System.out.println("로또 번호 : " + Arrays.toString(lottoController.getLotto()));

        closingDate.setDate(closingDate.getDate() + 1);
        lotto[0] = 10;
        lotto[1] = 11;
        lotto[2] = 12;

        System.out.println("로또 정보를 공격한 이후의 값");
        System.out.println("마감일 : " + lottoController.getClosingDate());
        System.out.println("로또 번호 : " + Arrays.toString(lottoController.getLotto()));
    }
}
