package springmain.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springmain.core.member.Grade;
import springmain.core.member.Member;
import springmain.core.member.service.MemberService;
import springmain.core.order.Order;
import springmain.core.order.service.OrderService;

public class OrderApp {
  public static void main(String[] args) {
  /*
    applicationContext spring container라고 함
    @Configuration이 붙은 appconfig설정 정보로 사용
    스프링 컨테이너에 객체를 스프링 빈으로 등록, 스프링 컨테이너에서 스프링 빈을 찾아서 사용하도록 변경
   */

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemAA", 10000);

    System.out.println(order);
  }
}
