package springmain.core;

import springmain.core.discount.FixDiscountPolicy;
import springmain.core.member.repository.MemoryMemberRepository;
import springmain.core.member.service.MemberService;
import springmain.core.member.service.MemberServiceImpl;
import springmain.core.order.service.OrderService;
import springmain.core.order.service.OrderServiceImpl;

public class AppConfig {
  public MemberService memberService() {
    return new MemberServiceImpl(new MemoryMemberRepository()); // 생성자 주입
  }

  public OrderServiceImpl orderService() {
    return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
  }
}
