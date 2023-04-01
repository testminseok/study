package com.software.optimize.problem.mutator;

import java.util.Date;

/**
 * @title: 로또 API 클래스
 * @description: 클래스의 변경을 방지하기 위해 상수 클래스로 등록
 */
public final class LottoController {

    private final Date closingDate;

    private final int[] lotto;

    public LottoController(Date closingDate, int[] lotto) {
        this.closingDate = closingDate;
        this.lotto = lotto;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public int[] getLotto() {
        return lotto;
    }
}
