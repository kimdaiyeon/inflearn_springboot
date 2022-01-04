package inflearn.inflearnspringboot.chapter2.discount;

import inflearn.inflearnspringboot.chapter2.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
