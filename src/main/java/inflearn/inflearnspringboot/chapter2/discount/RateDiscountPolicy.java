package inflearn.inflearnspringboot.chapter2.discount;

import inflearn.inflearnspringboot.chapter2.annotation.MainDiscountPolicy;
import inflearn.inflearnspringboot.chapter2.member.Grade;
import inflearn.inflearnspringboot.chapter2.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPersent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price*discountPersent / 100;
        }else{
            return 0;
        }
    }
}
