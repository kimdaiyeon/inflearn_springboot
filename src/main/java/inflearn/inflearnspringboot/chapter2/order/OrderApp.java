package inflearn.inflearnspringboot.chapter2.order;

import inflearn.inflearnspringboot.chapter2.AppConfig;
import inflearn.inflearnspringboot.chapter2.member.Grade;
import inflearn.inflearnspringboot.chapter2.member.Member;
import inflearn.inflearnspringboot.chapter2.member.MemberService;
import inflearn.inflearnspringboot.chapter2.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId= 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println(order);

    }
}
