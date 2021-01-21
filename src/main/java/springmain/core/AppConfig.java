package springmain.core;

import springmain.core.discount.DiscountPolicy;
import springmain.core.discount.RateDiscountPolicy;
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

  private DiscountPolicy discountPolicy() {
    return new RateDiscountPolicy();
  }

  public OrderServiceImpl orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }
}
