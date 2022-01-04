package inflearn.inflearnspringboot.chapter2.order;

import inflearn.inflearnspringboot.chapter2.AppConfig;
import inflearn.inflearnspringboot.chapter2.member.Grade;
import inflearn.inflearnspringboot.chapter2.member.Member;
import inflearn.inflearnspringboot.chapter2.member.MemberService;
import inflearn.inflearnspringboot.chapter2.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        //given
        Long memberId= 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
