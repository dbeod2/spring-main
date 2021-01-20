package springmain.core;

import springmain.core.discount.FixDiscountPolicy;
import springmain.core.member.repository.MemoryMemberRepository;
import springmain.core.member.service.MemberService;
import springmain.core.member.service.MemberServiceImpl;
import springmain.core.order.service.OrderServiceImpl;

public class AppConfig {
  private MemoryMemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository()); // 생성자 주입
  }

  private FixDiscountPolicy discountPolicy() {
    return new FixDiscountPolicy();
  }

  public OrderServiceImpl orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }
}
