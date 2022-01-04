package inflearn.inflearnspringboot.chapter2;

import inflearn.inflearnspringboot.chapter2.discount.DiscountPolicy;
import inflearn.inflearnspringboot.chapter2.discount.FixDiscountPolicy;
import inflearn.inflearnspringboot.chapter2.discount.RateDiscountPolicy;
import inflearn.inflearnspringboot.chapter2.member.MemberRepository;
import inflearn.inflearnspringboot.chapter2.member.MemberService;
import inflearn.inflearnspringboot.chapter2.member.MemberServiceImpl;
import inflearn.inflearnspringboot.chapter2.member.MemoryMemberRepository;
import inflearn.inflearnspringboot.chapter2.order.OrderService;
import inflearn.inflearnspringboot.chapter2.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
