package com.software.optimize.solution.mutator;

import java.util.Date;

/**
 * @title: 로또 API 클래스
 * @description: 클래스의 변경을 방지하기 위해 상수 클래스로 등록
 */
public final class LottoController {

    private final Date closingDate;

    private final int[] lotto;

    public LottoController(Date closingDate, int[] lotto) {
        this.lotto = new int[lotto.length];

        // 배열을 복사하여 내부에 저장
        System.arraycopy(lotto, 0, this.lotto, 0, lotto.length);

        // Date 객체를 복사하여 내부에 저장
        this.closingDate = new Date(closingDate.getTime());
    }

    public Date getClosingDate() {
        // 객체를 그대로 전달하지 않고
        // 새로운 객체를 생성하고 내부 필드를 복제해서 전달한다.
        return new Date(closingDate.getTime());
    }

    public int[] getLotto() {
        // 객체를 그대로 전달하지 않고
        // 새로운 객체를 생성하고 내부 필드를 복제해서 전달한다.
        return lotto.clone();
    }
}
