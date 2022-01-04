package inflearn.inflearnspringboot.chapter2.order;

import inflearn.inflearnspringboot.chapter2.annotation.MainDiscountPolicy;
import inflearn.inflearnspringboot.chapter2.discount.DiscountPolicy;
import inflearn.inflearnspringboot.chapter2.discount.FixDiscountPolicy;
import inflearn.inflearnspringboot.chapter2.discount.RateDiscountPolicy;
import inflearn.inflearnspringboot.chapter2.member.Member;
import inflearn.inflearnspringboot.chapter2.member.MemberRepository;
import inflearn.inflearnspringboot.chapter2.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
