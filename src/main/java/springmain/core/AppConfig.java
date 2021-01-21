package springmain.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springmain.core.discount.DiscountPolicy;
import springmain.core.discount.RateDiscountPolicy;
import springmain.core.member.repository.MemberRepository;
import springmain.core.member.repository.MemoryMemberRepository;
import springmain.core.member.service.MemberService;
import springmain.core.member.service.MemberServiceImpl;
import springmain.core.order.service.OrderService;
import springmain.core.order.service.OrderServiceImpl;

@Configuration
public class AppConfig {

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  @Bean
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository()); // 생성자 주입
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    return new RateDiscountPolicy();
  }

  @Bean
  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }
}
