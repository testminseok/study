package com.software.basic.problem.string;

import java.util.function.Supplier;

/**
 * 5-1 올바른 주석 사용법
 * - CommentRequired : 소스코드를 분석하여 주석의 첨삭을 권고한다.
 * - CommentSize : 주석의 길이가 너무 길때 수정을 권고한다. (기본값 세로 8줄 가로 80자)
 * - CommentContent : 주석에 사용 금지된 문자를 관리하며 금지된 문자를 사용할 경우 수정을 권고한다. (기본값 : idiot | jerk)
 */
public class CommentExample {

    /**
     * @Class Name : CouponServiceImpl.java
     * @Description : 쿠폰 기능을 담당하는 서비스를 구현한 객체
     * @Modification : Information
     * @
     * @    수정일           수정자     수정내용
     * @    2023-02-27      홍길동     최초 생성
     *
     * @author 홍길동
     * @since 2023-02-27
     * @version 1.0
     * */
    class CouponServiceImpl {

        public Coupon issue(final Supplier<String> supplier) {
            /* 쿠폰 코드 추출 */
            final String couponCode = supplier.get();

            // 잘못된 쿠폰인 경우
//            if (couponCode.isEmpty()) {
//                System.out.println("쿠폰 번호가 없다.");
//            }

            return new Coupon(couponCode);
        }
    }

    class Coupon {
        private final String couponCode; /* 쿠폰 코드 */
        public Coupon(final String couponCode) {
            this.couponCode = couponCode;
        }
    }
}

