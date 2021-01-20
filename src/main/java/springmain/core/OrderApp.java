package springmain.core;

import springmain.core.member.Grade;
import springmain.core.member.Member;
import springmain.core.member.service.MemberService;
import springmain.core.order.Order;
import springmain.core.order.service.OrderService;

public class OrderApp {
  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemAA", 10000);

    System.out.println(order);
  }
}
