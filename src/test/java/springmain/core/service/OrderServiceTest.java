package springmain.core.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springmain.core.discount.FixDiscountPolicy;
import springmain.core.member.Grade;
import springmain.core.member.Member;
import springmain.core.member.repository.MemoryMemberRepository;
import springmain.core.member.service.MemberService;
import springmain.core.member.service.MemberServiceImpl;
import springmain.core.order.Order;
import springmain.core.order.service.OrderService;
import springmain.core.order.service.OrderServiceImpl;

public class OrderServiceTest {

  MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
  OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

  @Test
  public void createOrder() {
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemAA", 10000);

    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}
